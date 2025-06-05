package com.example.springEducation;

public interface Gun {
    int getId();
    String getModel();       // formerly getTitle()
    String getManufacturer(); // formerly getAuthor()
    String getCategory();
    int getCaliber();        // formerly getPages()

    void setModel(String modelName);
    void setCaliber(Integer caliber);
    void setManufacturer(String manufacturer);
}
