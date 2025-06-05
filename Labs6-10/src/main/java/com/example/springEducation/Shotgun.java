package com.example.springEducation;

public class Shotgun implements Gun {
    private int id;
    private String model;
    private String manufacturer;
    private int caliber;

    public Shotgun(int id, String model, String manufacturer, int caliber) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.caliber = caliber;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setCaliber(Integer caliber) {

    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getCategory() {
        return "Shotgun";
    }

    @Override
    public int getCaliber() {
        return caliber;
    }
}
