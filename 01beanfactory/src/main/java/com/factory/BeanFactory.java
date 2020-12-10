package com.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author wangquan
 * @date 2020/12/10
 */
public class BeanFactory {
    private static Properties properties;
    private static Map<String,Object> beans;
    // 通过静态代码块对Properties初始化
    static {
        try {
            properties = new Properties();
            beans = new HashMap<>();
            // 2、获取properties的文件流
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(inputStream);
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()){
                String beanName = (String) keys.nextElement();
                String className = properties.getProperty(beanName);
                Object bean = Class.forName(className).newInstance();
                beans.put(beanName,bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
