package com.springtest.proxytest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wangquan
 * @date 2020/10/22
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Say say = new SayHello();
        Say say2 = new SayHello2();
        Method method = Say.class.getMethod("say", String.class);
        Object invoke = method.invoke(say, "张三");
        Object invoke2 = method.invoke(say2, "张三");
        System.out.println(invoke);
    }
}
