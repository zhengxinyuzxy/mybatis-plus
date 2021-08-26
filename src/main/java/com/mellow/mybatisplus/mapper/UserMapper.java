package com.mellow.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellow.mybatisplus.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    // 自定义mapper
    List<User> selectUserByName(String name);

    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page  分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param age 状态
     * @return 分页对象
     */
    IPage<User> selectPage(Page<?> page, Integer age);
}
