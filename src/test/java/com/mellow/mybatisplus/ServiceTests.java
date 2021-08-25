package com.mellow.mybatisplus;

import com.mellow.mybatisplus.entity.User;
import com.mellow.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceTests {

    @Resource
    private UserService userService;

    @Test
    public void count() {
        System.out.println("总记录数为：" + userService.count());
    }

    @Test
    public void saveBatch() {
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setName("蜻蜓" + i);
            user.setAge(20 + i);
            user.setEmail("qingting" + i + "@qq.com");
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println("批量添加是否成功：" + b);
    }

     @Test
    public void testListSelectByName() {
         List<User> users = userService.listSelectByName("李旦2");
         users.forEach(System.out::println);
     }
}
