package com.bean;


import java.util.*;

/**
 * @author w
 * @date 2020/12/13
 */
public class Student {

    private String[] array;
    private List<String> lists;
    private Set<String> sets;
    private Map<String,String> map;
    private Properties properties;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setStrings(List<String> lists) {
        this.lists = lists;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Student{" +
                "array=" + Arrays.toString(array) +
                ", lists=" + lists +
                ", sets=" + sets +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
