package proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangquan
 * @date 2020/12/16
 */
public class Consumer {
    public static void main(final String[] args) {
        final Product product = new Product();
        Product proxyProduct =(Product) Enhancer.create(product.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Float money = (Float) objects[0];
                Object returnValue = null;
                if("sell".equals(method.getName())){
                    returnValue = method.invoke(product, 0.8f * money);
                }
                return returnValue;
            }
        });
        System.out.println(proxyProduct.sell(1000f));
    }
}
