package com.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


public class Registered implements Serializable {
    private static final long serialVersionUID = 1L;
    public Date date;
    public int age;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Registered(Date date, int age) {
        this.date = date;
        this.age = age;
    }

    public Registered() {
    }

    @Override
    public String toString() {
        return "Registered{" +
                "date=" + date +
                ", age=" + age +
                '}';
    }
}
