package com.skytech.skytourism.usermanagement.domain.service.impl;

import com.skytech.skytourism.usermanagement.domain.model.User;
import com.skytech.skytourism.usermanagement.domain.repository.UserRepository;
import com.skytech.skytourism.usermanagement.domain.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Lianhong_ on 2018/05/18 11:50
 */
@Service(value = "userService")
public class DefaultUserService implements UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Override
    public User getUserBy(String id) {
        return new User(id, "lionkissadeer");
    }
}
