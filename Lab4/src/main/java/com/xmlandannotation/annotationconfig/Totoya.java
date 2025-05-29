package com.xmlandannotation.annotationconfig;

import org.springframework.stereotype.Component;

@Component
public class Totoya implements Car {
    @Override
    public String getModel() {
        return "Totoya";
    }
}