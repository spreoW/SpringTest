package com.factory;

import com.service.IAccountService;
import com.utils.LoggerUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangquan
 * @date 2020/12/19
 */
public class Beanfactroy {
    private IAccountService accountService;
    private LoggerUtil loggerUtil;
    String otherMethod = "otherMethod";

    public IAccountService getAccountService() {
        IAccountService proxyAccountService = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // otherMethod方法不需要增强
                if(otherMethod.equals(method.getName())){
                    return method.invoke(method,args);
                }
                loggerUtil.beforePrintLog();
                Object returnValue = method.invoke(accountService, args);
                return returnValue;
            }
        });
        return proxyAccountService;
    }

    public IAccountService getAccountServiceByCglib() {
        IAccountService proxyAccountService = (IAccountService) Enhancer.create(IAccountService.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // otherMethod方法不需要增强
                if(otherMethod.equals(method.getName())){
                    return method.invoke(accountService,objects);
                }
                loggerUtil.beforePrintLog();
                Object returnValue = method.invoke(accountService,objects);
                return returnValue;
            }
        });
        return proxyAccountService;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setLoggerUtil(LoggerUtil loggerUtil) {
        this.loggerUtil = loggerUtil;
    }
}
