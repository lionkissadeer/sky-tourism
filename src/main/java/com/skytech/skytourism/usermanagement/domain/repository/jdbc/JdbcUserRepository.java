package com.skytech.skytourism.usermanagement.domain.repository.jdbc;

import com.skytech.skytourism.application.idgen.IdentityGenerator;
import com.skytech.skytourism.usermanagement.domain.model.User;
import com.skytech.skytourism.usermanagement.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Lianhong_ on 2018/05/18 11:51
 */
@Repository(value = "userRepository")
public class JdbcUserRepository implements UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(JdbcUserRepository.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Resource(name = "identityGenerator")
    private IdentityGenerator identityGenerator;

    private String findByNameSql = "select id, name, password, " +
            "gender, age, birthday, remark from user where id = ?";

    @Override
    public User findById(String id) {
        try {
            return namedParameterJdbcTemplate.getJdbcOperations()
                    .queryForObject(findByNameSql, new BeanPropertyRowMapper<>(User.class), id);
        } catch (DataAccessException e) {
            logger.error("查询用户信息失败。", e);
            return null;
        }
    }

    private String insertUserSql = "insert into user (id, name, password, gender, age, birthday, remark)" +
            "values(:id, :name, :password, :gender, :age, :birthday, :remark)";

    @Override
    public void saveUser(User user) {
        try {
            user.setId(identityGenerator.generate());
            namedParameterJdbcTemplate.update(insertUserSql, new BeanPropertySqlParameterSource(user));
        } catch (DataAccessException e) {
            logger.error("新增用户信息失败", e);
        }
    }

    private String userIsExistSql = "select count(1) from user where name = ?";

    @Override
    public boolean userIsExist(String name) {
        return namedParameterJdbcTemplate.getJdbcOperations().queryForObject(userIsExistSql, Boolean.class, name);
    }
}
