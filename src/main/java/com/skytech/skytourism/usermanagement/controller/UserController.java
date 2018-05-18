package com.skytech.skytourism.usermanagement.controller;

import com.skytech.skytourism.usermanagement.domain.model.User;
import com.skytech.skytourism.usermanagement.domain.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Lianhong_ on 2018/05/18 11:51
 */
@RestController
@RequestMapping(value = "users")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User userInfo(@PathVariable(value = "id") String id) {
        return userService.getUserBy(id);
    }

}