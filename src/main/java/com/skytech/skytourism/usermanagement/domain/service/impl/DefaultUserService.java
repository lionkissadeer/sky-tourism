package com.skytech.skytourism.usermanagement.domain.service.impl;

import com.skytech.skytourism.usermanagement.domain.exception.UserException;
import com.skytech.skytourism.usermanagement.domain.model.User;
import com.skytech.skytourism.usermanagement.domain.repository.UserRepository;
import com.skytech.skytourism.usermanagement.domain.repository.jpa.JpaUserRepository;
import com.skytech.skytourism.usermanagement.domain.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        return userRepository.findById(id);
    }

    @Override
    public void register(User user) {
        if (userRepository.userIsExist(user.getUsername()))
            throw new UserException("Register-001", "用户名已存在。");
        userRepository.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        if (!userRepository.userIsExist(username, password))
            throw new UserException("Login-001", "用户不存在，请先注册。");
        return jpaUserRepository.findBy(username);
    }
}
