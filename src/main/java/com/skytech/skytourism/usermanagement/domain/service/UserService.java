package com.skytech.skytourism.usermanagement.domain.service;

import com.skytech.skytourism.usermanagement.domain.model.User;

import java.util.List;

/**
 * Created by Lianhong_ on 2018/05/18 11:49
 */
public interface UserService {

    List<User> getUsers();

    User getUserBy(String id);

    User register(User user);

    User login(String username, String password);

    User getUserByUsername(String username);
}
