package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guy {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Id
    // 实现自增，括号后少不了，否则会导致缺少自增的那一列
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String height;

    public Guy(){

    }

}
