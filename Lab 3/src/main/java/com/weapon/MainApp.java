package com.weapon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        WeaponDisplay display = (WeaponDisplay) context.getBean("weaponDisplay");
        display.show();
    }
}
