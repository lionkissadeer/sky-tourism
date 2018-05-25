package com.skytech.skytourism.usermanagement.controller;

import com.skytech.skytourism.usermanagement.controller.resource.UserResourceAssembler;
import com.skytech.skytourism.usermanagement.domain.model.User;
import com.skytech.skytourism.usermanagement.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Lianhong_ on 2018/05/18 11:51
 */
@RestController
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private UserResourceAssembler assembler;

    @PostMapping(value = "/register", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resource<User>> register(@RequestBody User user) {
        return ResponseEntity.ok(assembler.toResource(userService.register(user)));
    }

    @PostMapping(value = "/users/login", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resource<User>> login(@RequestBody User user) {
        return ResponseEntity.ok(assembler.toResource(userService.login(user.getUsername(), user.getPassword())));
    }

    @GetMapping(value = "/users", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resources<Resource<User>>> users() {
        return ResponseEntity.ok(assembler.toResources(userService.getUsers()));
    }

    @GetMapping(value = "/users/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resource<User>> userInfo(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(assembler.toResource(userService.getUserBy(id)));
    }

    @GetMapping(value = "/users/name/{username}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resource<User>> userInfoByName(@PathVariable(value = "username") String username) {
        return ResponseEntity.ok(assembler.toResource(userService.getUserByUsername(username)));
    }


}
