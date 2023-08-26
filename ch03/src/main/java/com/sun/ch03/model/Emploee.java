package com.sun.ch03.model;

public class Emploee {
    private String name;

    // 無參數建構子
    public Emploee() {
    }

    // 全參數建構子
    public Emploee(String name) {
        this.name = name;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // setter for name
    public void setName(String name) {
        this.name = name;
    }

}
