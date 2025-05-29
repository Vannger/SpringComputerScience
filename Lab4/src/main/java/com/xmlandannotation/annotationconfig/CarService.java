package com.xmlandannotation.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class CarService {

    private final Car car;

    @Autowired
    public CarService(@Qualifier("totoya") Car car) {
        this.car = car;
    }

    @PostConstruct
    public void init() {
        System.out.println("CarService initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CarService destroyed.");
    }

    public void showCarInfo() {
        System.out.println("Current car: " + car.getModel());
    }
}