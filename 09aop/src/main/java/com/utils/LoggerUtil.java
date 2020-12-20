package com.utils;

/**
 * @author wangquan
 * @date 2020/12/19
 */
public class LoggerUtil {
    public void beforePrintLog(){
        System.out.println("beforePrintLog执行了。。。");
    }
    public void afterReturnPrintLog(){
        System.out.println("afterReturnPrintLog执行了。。。");
    }
    public void afterThrowingPrintLog(){
        System.out.println("afterThrowingPrintLog执行了。。。");
    }
    public void afterPrintLog(){
        System.out.println("afterPrintLog执行了。。。");
    }
}
