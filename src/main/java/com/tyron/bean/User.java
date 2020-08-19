package com.tyron.bean;

import lombok.Data;

@Data
public class User {

    private String name;

    private Integer age;

    private String address;

    User(){}

    public User(String name, Integer age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

}
