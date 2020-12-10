package com.springtest.entity;

import org.springframework.stereotype.Component;

/**
 * @author wangquan
 * @date 2020/9/23
 */
@Component
public class Dog implements Pet {
    @Override
    public void move() {
        System.out.println("小狗在移动。。。");
    }
}
