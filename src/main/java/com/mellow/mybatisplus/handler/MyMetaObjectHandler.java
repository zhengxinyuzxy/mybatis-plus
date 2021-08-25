package com.mellow.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert 执行！");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        // 判断当前属性是否存在set方法，返回值为布尔值
        boolean authorString = metaObject.hasSetter("author");
        if (authorString) {
            log.info("添加作者执行！");
            this.strictInsertFill(metaObject, "author", String.class, "作者：郑**");
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("Update 执行！");
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
