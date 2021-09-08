package com.appdemo.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Map;

/**
 * @author ay
 * @since 20201-09-07
 */
public class User implements  Serializable {

    private String name;
    private int age;
    @JsonIgnore
    private transient String uniqueId;
    private Map<Object, Object> userinfo;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Map<Object, Object> getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Map<Object, Object> userinfo) {
        this.userinfo = userinfo;
    }

    public String getName() {
        return name;
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", uniqueId='" + uniqueId + '\'' +
                ", userinfo=" + userinfo +
                '}';
    }
}
