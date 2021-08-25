package com.mellow.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "t_user")
public class User {

    // mybatis默认识别id字段，自动生成雪花算法的id值
    @TableId(value = "uid",type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // 逻辑删除tablelogic
    @TableLogic
    @TableField(value = "is_deleted")
    private boolean deleted;
}
