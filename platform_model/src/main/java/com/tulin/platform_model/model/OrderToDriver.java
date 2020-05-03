package com.tulin.platform_model.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName(value = "order_to_driver")
public class OrderToDriver extends BaseEntity {
    @TableField(value = "moto_driver_id")
    private Long motoDriverId;
    @TableField(value = "order_id")
    private Long orderId;


}
