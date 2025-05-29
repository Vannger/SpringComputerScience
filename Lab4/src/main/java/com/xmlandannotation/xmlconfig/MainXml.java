package com.xmlandannotation.xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Car car = context.getBean("car", Car.class);
        System.out.println(car);

        context.close();
    }
}