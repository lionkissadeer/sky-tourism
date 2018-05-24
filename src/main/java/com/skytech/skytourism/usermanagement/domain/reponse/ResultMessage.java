package com.skytech.skytourism.usermanagement.domain.reponse;

import com.skytech.skytourism.usermanagement.domain.jwt.AccessToken;
import com.skytech.skytourism.usermanagement.domain.jwt.Audience;

/**
 * Created by Lianhong_ on 2018/05/23 18:42
 */
public class ResultMessage {

    private int code;
    private String message;
    private Audience audience;
    private AccessToken token;

    public ResultMessage(int code, String message, Audience audience) {
        this(code, message);
        this.audience = audience;
    }

    public ResultMessage(int code, String message, AccessToken token) {
        this(code, message);
        this.token = token;
    }

    public ResultMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AccessToken getToken() {
        return token;
    }

    public void setToken(AccessToken token) {
        this.token = token;
    }
}
