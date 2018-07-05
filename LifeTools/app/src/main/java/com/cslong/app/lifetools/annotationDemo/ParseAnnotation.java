package com.cslong.app.lifetools.annotationDemo;

import java.lang.reflect.Field;

/**
 * Created by chenlongjian on 2018/6/25.
 */

public class ParseAnnotation {


    public static void parseAnnotation(Object obj) throws IllegalAccessException {
        System.out.println("进入");
        Class<? extends Object> objClass = obj.getClass();
        Field[] fields = objClass.getFields();
        System.out.println(fields.length);
        for (Field field : fields) {
            System.out.println("循环");
            // 判断该字段是否存在CustomAnnotation注解
            if (field.isAnnotationPresent(TestAnnotation.class)) {
                System.out.println("运行！！！！！");
                // 得到该注解对象
                TestAnnotation customAnnotation = field.getAnnotation(TestAnnotation.class);
                // 得到注解的成员
                String value = customAnnotation.value();
                // 传入对象设置字段
                field.set(obj, value);
            }
        }
    }
}
