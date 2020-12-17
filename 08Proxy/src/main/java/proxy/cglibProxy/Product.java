package proxy.cglibProxy;

import proxy.jdkProxy.IProduct;

/**
 * @author wangquan
 * @date 2020/12/16
 */
public class Product implements IProduct {

    @Override
    public String sell(Float money) {
        System.out.println("代理员交给工厂："+money);
        return "aaa";
    }

    @Override
    public void afterSell() {
        System.out.println("代理员做售后。。");
    }
}
