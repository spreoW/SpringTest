package com.utils;

import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangquan
 * @date 2020/12/17
 */
public class BeanFactory {

    @Autowired
    @Qualifier("accountService")
    private IAccountService iAccountService;

    @Autowired
    TransactionManager transactionManager;

    public IAccountService getAccountService() {
        IAccountService proxyIaccountService = (IAccountService) Proxy.newProxyInstance(iAccountService.getClass().getClassLoader(), iAccountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                try {
                    transactionManager.beginTransaction();
                    System.out.println("开启事务。。。");
                    System.out.println("执行【"+method.getName()+"】方法。。。");
                    returnValue = method.invoke(iAccountService, args);
                    System.out.println(5/0);
                    transactionManager.commitTransaction();
                    System.out.println("COMMIT事务。。。");
                }catch (Exception e){
                    System.out.println("ROLLBACK事务。。。");
                    transactionManager.rollbackTransaction();
                    e.printStackTrace();
                }finally {
                    transactionManager.release();
                }
                return returnValue;
            }
        });
        return proxyIaccountService;
    }

    public void setiAccountService(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }
}
