package com.skytech.skytourism.usermanagement.domain.repository;

import com.skytech.skytourism.usermanagement.domain.model.User;

/**
 * Created by Lianhong_ on 2018/05/18 11:50
 */
public interface UserRepository {

    User findById(String name);
}
