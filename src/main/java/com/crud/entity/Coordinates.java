package com.crud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Coordinates implements Serializable {
    private static final long serialVersionUID = 1L;
     private String latitude;
    private String longitude;
}
