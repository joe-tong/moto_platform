package com.tulin.platform_model.dao;

import com.tulin.platform_model.model.User;
import org.springframework.data.repository.query.Param;

public interface UserDao extends BaseDao<User> {

    User queryByUserName(@Param("nickName") String nickName);

}
