package com.crud.entity;



import java.io.Serializable;


public class Id implements Serializable {
    private static final long serialVersionUID = 1L;

    public String name;
    public String value;

    @Override
    public String toString() {
        return "Id{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Id(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Id() {
    }
}
