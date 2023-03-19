package com.crud.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;


@Entity
public class Root implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ArrayList<Result> results;
    public Info info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
