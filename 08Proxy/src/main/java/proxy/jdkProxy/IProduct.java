package proxy.jdkProxy;

/**
 * @author wangquan
 * @date 2020/12/16
 */
public interface IProduct {
    String sell(Float money);
    void afterSell();
}
