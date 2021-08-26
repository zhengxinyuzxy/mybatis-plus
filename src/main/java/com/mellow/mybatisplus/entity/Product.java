package com.mellow.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
@TableName(value = "t_product")
public class Product {

    @TableId(value = "pid",type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;
}
