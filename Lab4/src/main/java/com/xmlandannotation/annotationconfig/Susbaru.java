package com.xmlandannotation.annotationconfig;

import org.springframework.stereotype.Component;

@Component
public class Susbaru implements Car {
    @Override
    public String getModel() {
        return "Susbaru";
    }
}