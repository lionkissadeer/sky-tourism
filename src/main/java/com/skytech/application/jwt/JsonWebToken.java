package com.skytech.application.jwt;

import com.skytech.application.aes.Aes;
import com.skytech.application.jwt.response.ResultMessage;
import com.skytech.application.jwt.response.ResultStatusCode;
import com.skytech.skytourism.usermanagement.domain.model.User;
import com.skytech.skytourism.usermanagement.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
/**
 * Created by Lianhong_ on 2018/05/23 18:28
 */
@RestController
public class JsonWebToken {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Audience audienceEntity;

    @PostMapping("oauth/token")
    public Object getAccessToken(@RequestBody LoginPara loginPara) {
        ResultMessage resultMessage;
        try {
            if (loginPara.getClientId() == null
                    || (loginPara.getClientId().compareTo(audienceEntity.getClientId()) != 0)) {
                resultMessage = new ResultMessage(ResultStatusCode.INVALID_CLIENTID.getCode(),
                        ResultStatusCode.INVALID_CLIENTID.getMessage());
                return resultMessage;
            }

            //todo:验证码添加


            //验证用户名密码
            User user = userRepository.findUserByName(loginPara.getUsername());
            if (user == null) {
                resultMessage = new ResultMessage(ResultStatusCode.INVALID_PASSWORD.getCode(),
                        ResultStatusCode.INVALID_PASSWORD.getMessage());
                return resultMessage;
            } else {
                String aesPassword = Aes.aesEncrypt(loginPara.getPassword(), Aes.KEY);

                if (aesPassword.compareTo(user.getPassword()) != 0) {
                    resultMessage = new ResultMessage(ResultStatusCode.INVALID_PASSWORD.getCode(),
                            ResultStatusCode.INVALID_PASSWORD.getMessage());
                    return resultMessage;
                }
            }

            //拼装accessToken
            String accessToken = JwtHelper.createJWT(loginPara.getUsername(), String.valueOf(user.getUsername()),
                    user.getRole(), audienceEntity.getClientId(), audienceEntity.getName(),
                    audienceEntity.getExpiresSecond() * 1000, audienceEntity.getBase64Secret());

            //返回accessToken
            AccessToken accessTokenEntity = new AccessToken();
            accessTokenEntity.setAccess_token(accessToken);
            accessTokenEntity.setExpires_in(audienceEntity.getExpiresSecond());
            accessTokenEntity.setToken_type("bearer");
            resultMessage = new ResultMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMessage(), accessTokenEntity);
            return resultMessage;

        } catch (Exception ex) {
            resultMessage = new ResultMessage(ResultStatusCode.SYSTEM_ERR.getCode(),
                    ResultStatusCode.SYSTEM_ERR.getMessage());
            return resultMessage;
        }
    }
}