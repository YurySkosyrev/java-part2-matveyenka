package com.edu.reflectionApi;

import java.io.Serializable;

public class User extends Person implements Serializable, Comparable {

    private String name;
    @MinAge(age = 21)
    private int age;

    public User(Long id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
