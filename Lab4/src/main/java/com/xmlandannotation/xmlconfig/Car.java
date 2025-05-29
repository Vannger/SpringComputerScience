package com.xmlandannotation.xmlconfig;

public class Car {
    private String brand;
    private String model;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void init() {
        System.out.println("Bean Car initialized.");
    }

    public void destroy() {
        System.out.println("Bean Car destroyed.");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}