package com.mellow.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mellow.mybatisplus.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    // 自定义通用service
    List<User> listSelectByName(String name);
}
