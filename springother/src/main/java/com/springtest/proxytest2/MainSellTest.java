package com.springtest.proxytest2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author wangquan
 * @date 2020/10/22
 */
public class MainSellTest {
    public static void main(String[] args) {
        UsbSell usbSell = new KingUsbFactory();
        InvocationHandler invocationHandler = new MySellHandler(usbSell);
        KingUsbFactory o = (KingUsbFactory) Proxy.newProxyInstance(usbSell.getClass().getClassLoader(),
                usbSell.getClass().getInterfaces(),invocationHandler
                );
        float shlle = o.shlle(1);
        System.out.println(shlle);
    }
}
