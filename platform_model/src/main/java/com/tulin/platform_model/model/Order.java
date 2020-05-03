package com.tulin.platform_model.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName(value = "order_info")
public class Order extends BaseEntity {
    @TableField(value = "user_id")
    private Long userId;//发布订单人，用户
    @TableField(value = "state")
    private int state;
    @TableField(value = "tel")
    private String tel;

    private String longitude;
    private String latitude;
    private String address;
    private int mile;


}
