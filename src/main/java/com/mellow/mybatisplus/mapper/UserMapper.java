package com.mellow.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mellow.mybatisplus.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    // 自定义mapper
    List<User> selectUserByName(String name);
}
