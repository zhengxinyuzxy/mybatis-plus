package com.mellow.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mellow.mybatisplus.entity.User;
import com.mellow.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class WapperTest {

    @Resource
    private UserMapper userMapper;

    // 查询名字中包含小，年龄大于等于99且小于等于100，email不为空的用户
    @Test
    public void wapperTest01() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name","小")
                .between("age",99, 100)
                .isNotNull("email");
//                .ge("age",99)
//                .le("age", 100);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    // 组装排序条件->按年龄降序查询用户，如果年龄相同则按id升序排列
    @Test
    public void wapperTest02() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .orderByDesc("age")
                .orderByAsc("uid");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    // 组装删除条件->删除email为空的用户
    @Test
    public void wapperTest03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int deleteResult = userMapper.delete(queryWrapper);
        System.out.println(deleteResult);
    }

    // 条件的优先级->查询名字中包含n，且（年龄小于18或email为空的用户），并将这些用户的年龄设置为18，邮箱设置为 user@163.com
    @Test
    public void wapperTest04() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // 优先级问题.lt("age",18).or().isNull("email");与.like("name","小")
        //
        queryWrapper
                .like("name","小")
                .and(i -> i.gt("age",18).or().isNull("email"));

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
        User user = new User();
        user.setAge(18);
        user.setEmail("user@163.com");
        int updateResult = userMapper.update(user, queryWrapper);
        System.out.println(updateResult);
    }

    // 查询所有用户的用户名和年龄
    @Test
    public void wapperTest05() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age");
        // selectList返回封装实体属性默认值
//        List<User> users = userMapper.selectList(queryWrapper);
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    // 查询id不大于3的所有用户的id列表
    @Test
    public void wapperTest06() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.inSql("uid","select uid from t_user where uid < 10");
//        queryWrapper.in("uid",1,2,3,4,5);
        queryWrapper.le("uid",10);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
}
