package com.Person.Guy;

import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Person(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Perpetrator of the Crime: " +
                "First Name '" + firstName + '\'' +
                ", Last Name '" + lastName + '\'' +
                ", Birth Name " + birthDate +
                 " SVO"    ;
    }
}
