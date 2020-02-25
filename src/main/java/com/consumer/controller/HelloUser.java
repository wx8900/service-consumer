package com.consumer.controller;

public class HelloUser {
    private String name;
    private Integer age;

    //序列化传输的时候必须要有空构造方法，不然会出错
    public HelloUser() {
    }
    public HelloUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
