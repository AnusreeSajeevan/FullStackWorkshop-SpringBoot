package com.tw.restdemo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

@Data
public class User {

    private String name;
    private int id;
}

   /* public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}*/
