
package com.skytech.skytourism.usermanagement.domain.repository.jpa;

import com.skytech.skytourism.usermanagement.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Lianhong_ on 2018/05/18 14:14
 */
@Repository(value = "jpaUserRepository")
public interface JpaUserRepository extends JpaRepository<User, String> {

    @Query(value = "select new User(id, username, gender, age, birthday, remark) from User where username = ?1")
    User findBy(String username);
}

