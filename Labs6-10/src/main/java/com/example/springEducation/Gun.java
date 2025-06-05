package com.example.springEducation;

public interface Gun {
    int getId();
    String getModel();       // formerly getTitle()
    String getManufacturer(); // formerly getAuthor()
    String getCategory();
    int getCaliber();        // formerly getPages()
}
