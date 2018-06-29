package com.skytech.skytourism.usermanagement.domain.service.impl;

import com.skytech.application.exceptionhandler.exception.ApplicationException;
import com.skytech.skytourism.usermanagement.domain.model.User;
import com.skytech.skytourism.usermanagement.domain.repository.UserRepository;
import com.skytech.skytourism.usermanagement.domain.repository.jpa.JpaUserRepository;
import com.skytech.skytourism.usermanagement.domain.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lianhong_ on 2018/05/18 11:50
 */
@Service(value = "userService")
public class DefaultUserService implements UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Resource(name = "jpaUserRepository")
    private JpaUserRepository jpaUserRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public User getUserBy(String id) {
        User user = userRepository.findById(id);
        if (user == null)
            throw new ApplicationException("getUserBy-001", "用户不存在。");
        return user;
    }

    @Override
    public User register(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtils.isEmpty(username))
            throw new ApplicationException("Register-001", "用户名不能为空。");
        if (StringUtils.isEmpty(password))
            throw new ApplicationException("Register-002", "密码不能为空。");
        if (userRepository.userIsExist(username))
            throw new ApplicationException("Register-003", "用户名已存在。");
        if (this.isSpecialChar(username))
            throw new ApplicationException("Register-004", "用户名存在非法字符。");
        return userRepository.findById(userRepository.saveUser(user));
    }

    @Override
    public User login(String username, String password) {
        if (StringUtils.isEmpty(username))
            throw new ApplicationException("Login-001", "用户名不能为空。");
        if (StringUtils.isEmpty(password))
            throw new ApplicationException("Login-002", "密码不能为空。");
        if (!userRepository.userIsExist(username, password))
            throw new ApplicationException("Login-003", "用户不存在，请先注册。");
        return jpaUserRepository.findBy(username);
    }

    @Override
    public User getUserByUsername(String username) {
        return jpaUserRepository.findBy(username);
    }

    /**
     * 判断是否含有特殊字符
     *
     * @return true为包含，false为不包含
     */
    private boolean isSpecialChar(String val) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(val);
        return m.find();
    }
}
