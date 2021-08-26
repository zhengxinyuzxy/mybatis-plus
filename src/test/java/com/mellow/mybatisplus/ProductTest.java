package com.mellow.mybatisplus;

import com.mellow.mybatisplus.entity.Product;
import com.mellow.mybatisplus.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ProductTest {

    @Resource
    private ProductMapper productMapper;

    @Test
    public void testProduct() {
        // 模拟数据并发
        // 假如小黄拿数据
        Product product1 = productMapper.selectById(1L);

        // 假如小华拿数据
        Product product2 = productMapper.selectById(1L);

        // 假如小黄修改
        product1.setPrice(product1.getPrice()+50);
        int result01 = productMapper.updateById(product1);
        System.out.println("修改结果：" + result01);

        // 假如小华修改
        product2.setPrice(product2.getPrice()-30);
        int result02 = productMapper.updateById(product2);
        System.out.println("修改结果：" + result02);
        if (result02 == 0) {
            // 修改失败，重新尝试
            product2 = productMapper.selectById(1L);
            product2.setPrice(product2.getPrice()-30);
            result02 = productMapper.updateById(product2);
            System.out.println("重新尝试修改结果：" + result02);
        }

        // 审核人查看
        Product product3 = productMapper.selectById(1L);
        System.out.println(product3.getPrice());

    }

}
