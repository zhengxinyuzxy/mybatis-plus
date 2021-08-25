package com.mellow.mybatisplus;

import com.mellow.mybatisplus.entity.User;
import com.mellow.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MapperTests {
    @Resource
    private UserMapper userMapper;

    // 增加
    @Test
    public void addUser() {
        User user = new User();
        user.setName("小黄");
        user.setAge(99);
        user.setEmail("xiaohuang@qq.com");
        /*user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());*/
        int addResult = userMapper.insert(user);
        System.out.println("受影响行数：" + addResult);
        System.out.println("返回id为：" + user.getId());
    }

    // 根据id查询
    @Test
    public void selectUser() {
        User user = userMapper.selectById(2);
        System.out.println("返回实体类为：" + user);
    }

    // 根据条件查询
    @Test
    public void selectUserById() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "川普");
        map.put("age", 99);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 根据列表查询
    @Test
    public void selectUserBatchId() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    // 根据id更新
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1430412635114958863L);
        user.setName("小刚");
        user.setAge(100);
        user.setEmail("xiaogang@qq.com");
        int updateResult = userMapper.updateById(user);
        System.out.println("更新受影响的行数：" + updateResult);
    }

    // 根据id删除
    @Test
    public void deleteUser() {
        int deleteResult = userMapper.deleteById(5L);
        System.out.println("根据id删除受影响的行数：" + deleteResult);
    }

    // 批量删除
    @Test
    public void delectBatchUser() {
        int deleteResult = userMapper.deleteBatchIds(Arrays.asList(1, 3));
        System.out.println("批量删除受影响的行数：" + deleteResult);
    }

    // 根据条件删除
    @Test
    public void delectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "川普");
        map.put("age", 99);
        int deleteResult = userMapper.deleteByMap(map);
        System.out.println("批量删除受影响的行数：" + deleteResult);
    }

    // 根据自定义条件查询
    @Test
    public void selectUserByName() {
        List<User> users = userMapper.selectUserByName("李旦1");
        users.forEach(System.out::println);
    }




}
