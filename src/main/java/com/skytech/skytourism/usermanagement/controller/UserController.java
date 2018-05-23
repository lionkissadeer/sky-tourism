package com.skytech.skytourism.usermanagement.controller;

import com.skytech.skytourism.usermanagement.domain.model.User;
import com.skytech.skytourism.usermanagement.domain.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lianhong_ on 2018/05/18 11:51
 */
@RestController
@RequestMapping(value = "users")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping
    public List<User> users() {
        return userService.getUsers();
    }

    @GetMapping(value = "/{id}")
    public User userInfo(@PathVariable(value = "id") String id) {
        return userService.getUserBy(id);
    }

    @PostMapping(value = "/register")
    public void register(User user) {
        userService.register(user);
    }

    @PostMapping(value = "/login")
    public User login(@RequestParam("username") String username,
                      @RequestParam("password") String password) {
        return userService.login(username, password);
    }
}
