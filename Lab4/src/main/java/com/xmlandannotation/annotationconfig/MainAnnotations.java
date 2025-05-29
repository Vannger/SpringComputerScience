package com.xmlandannotation.annotationconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xmlandannotation.annotationconfig")
public class MainAnnotations {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainAnnotations.class);

        CarService carService = context.getBean(CarService.class);
        carService.showCarInfo();

        context.close();
    }
}