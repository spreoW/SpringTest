package com;

import com.bean.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author w
 * @date 2020/12/13
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("4、对初始化之前的Bean进行处理,此时我的名字：" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Student stu = null;
        String xmlBeanName = "student";
        System.out.println("6、对初始化之后的Bean进行处理,将Bean的成员变量的值修改了");
        if(xmlBeanName.equals(beanName) || bean instanceof Student) {
            stu = (Student) bean;
            stu.setName("李四");
        }
        return stu;
    }
}
