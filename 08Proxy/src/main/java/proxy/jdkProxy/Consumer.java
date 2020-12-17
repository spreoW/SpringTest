package proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangquan
 * @date 2020/12/16
 */
public class Consumer {
    public static void main(String[] args) {
        final Product product = new Product();
        IProduct proxyProduct = (IProduct) Proxy.newProxyInstance(product.getClass().getClassLoader(), product.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                Float money = (Float) args[0];
                if("sell".equals(method.getName())){
                    returnValue = method.invoke(product, money*0.8F);
                }
                return returnValue;
            }
        });
        System.out.println(proxyProduct.sell(1000F));
    }
}
