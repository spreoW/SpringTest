package com.springtest.proxytest2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangquan
 * @date 2020/10/22
 */
public class MySellHandler implements InvocationHandler {
    private Object target;

    public MySellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        res = method.invoke(target, args);
        float resfloat = (float) res;
        return resfloat;
    }
}
