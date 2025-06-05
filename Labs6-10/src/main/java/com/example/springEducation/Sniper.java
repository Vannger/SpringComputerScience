package com.example.springEducation;

public class Sniper implements Gun {
    private int id;
    private String model;
    private String manufacturer;
    private int caliber;

    public Sniper(int id, String model, String manufacturer, int caliber) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.caliber = caliber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
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
        return "Sniper";
    }

    @Override
    public int getCaliber() {
        return caliber;
    }
}
