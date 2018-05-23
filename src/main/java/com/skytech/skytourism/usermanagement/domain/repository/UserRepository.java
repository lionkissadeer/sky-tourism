package com.skytech.skytourism.usermanagement.domain.repository;

import com.skytech.skytourism.usermanagement.domain.model.User;

import java.util.List;

/**
 * Created by Lianhong_ on 2018/05/18 11:50
 */
public interface UserRepository {

    List<User> getUsers();

    User findById(String id);

    void saveUser(User user);

    boolean userIsExist(String username);

    boolean userIsExist(String username, String password);
}
