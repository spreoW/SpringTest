package com.springtest.proxytest;

/**
 * @author wangquan
 * @date 2020/10/22
 */
public class SayHello implements Say {
    @Override
    public void say(String name) {
        System.out.println(name+": hello");
    }
}
