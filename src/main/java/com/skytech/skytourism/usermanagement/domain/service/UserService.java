package com.skytech.skytourism.usermanagement.domain.service;

import com.skytech.skytourism.usermanagement.domain.model.User;

/**
 * Created by Lianhong_ on 2018/05/18 11:49
 */
public interface UserService {

    User getUserBy(String id);

    void register(User user);
}
