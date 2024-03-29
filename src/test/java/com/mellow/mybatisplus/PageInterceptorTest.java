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

        Page<User> pageParme = new Page<>(1,5);
        userMapper.selectPage(pageParme,99);

        List<User> records = pageParme.getRecords();
        records.forEach(System.out::println);

        long total = pageParme.getTotal();
        System.out.println("记录数量为：" + total);

        boolean bNext = pageParme.hasNext();
        System.out.println("是否有下一页" + bNext);

        boolean bPrevious = pageParme.hasPrevious();
        System.out.println("是否有上一页" + bPrevious);


    }
}
