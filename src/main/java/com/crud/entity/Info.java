package com.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Info implements Serializable {
    private static final long serialVersionUID = 1L;
    public String seed;
    public int results;
    public int page;
    public String version;
}
