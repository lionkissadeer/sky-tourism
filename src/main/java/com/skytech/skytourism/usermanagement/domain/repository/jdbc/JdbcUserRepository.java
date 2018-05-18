package com.skytech.skytourism.usermanagement.domain.repository.jdbc;

import com.skytech.skytourism.application.idgen.IdentityGenerator;
import com.skytech.skytourism.usermanagement.domain.model.User;
import com.skytech.skytourism.usermanagement.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Lianhong_ on 2018/05/18 11:51
 */
@Repository(value = "userRepository")
public class JdbcUserRepository implements UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Resource(name = "identityGenerator")
    private IdentityGenerator identityGenerator;

    private String findByNameSql = "select id, name, password, " +
            "gender, age, birthday, remark from user where id = :id";

    @Override
    public User findById(String id) {
        return namedParameterJdbcTemplate.getJdbcOperations()
                .queryForObject(findByNameSql, new BeanPropertyRowMapper<>(User.class), id);
    }

}
