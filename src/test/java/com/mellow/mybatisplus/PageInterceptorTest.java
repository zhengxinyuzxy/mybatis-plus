package com.mellow.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellow.mybatisplus.entity.User;
import com.mellow.mybatisplus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
public class PageInterceptorTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void interceptorPage() {
        Page<User> pageParme = new Page<>(1,3);
        userMapper.selectPage(pageParme,null);
        List<User> records = pageParme.getRecords();
        records.forEach(System.out::println);
    }
}
