package com.tulin.platform_model.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseEntity implements Serializable {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "modify_time")
    private Date modifyTime;
    @TableField(value = "is_deleted")
    private int isDeleted;
}
