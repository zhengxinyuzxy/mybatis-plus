package com.mellow.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mellow.mybatisplus.entity.User;
import com.mellow.mybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    /*@Resource
    private UserMapper userMapper;*/

    @Override
    public List<User> listSelectByName(String name) {
        return baseMapper.selectUserByName(name);
    }
}
