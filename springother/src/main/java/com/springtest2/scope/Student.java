package com.springtest2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author wangquan
 * @date 2020/12/9
 */
@Component("student")
@Scope("prototype")
public class Student {
    private String study;

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }
}
