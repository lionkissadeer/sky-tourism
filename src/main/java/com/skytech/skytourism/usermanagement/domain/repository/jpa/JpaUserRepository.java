
package com.skytech.skytourism.usermanagement.domain.repository.jpa;

import com.skytech.skytourism.usermanagement.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lianhong_ on 2018/05/18 14:14
 */
@Repository(value = "jpaUserRepository")
public interface JpaUserRepository extends CrudRepository<User, String> {

    User findByNameLike(String username);
}

