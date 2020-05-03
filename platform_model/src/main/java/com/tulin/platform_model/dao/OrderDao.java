package com.tulin.platform_model.dao;

import com.tulin.platform_model.model.Order;
import com.tulin.platform_model.model.User;
import org.springframework.data.repository.query.Param;

public interface OrderDao extends BaseDao<Order> {

    Order findOrderByState(@Param("state") int state);
}
