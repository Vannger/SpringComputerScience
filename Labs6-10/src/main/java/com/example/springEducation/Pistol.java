package com.example.springEducation;

public class Pistol implements Gun {
    private int id;
    private String model;
    private String manufacturer;
    private int caliber;

    public Pistol(int id, String model, String manufacturer, int caliber) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
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

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setCaliber(Integer caliber) {

    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getCategory() {
        return "Pistol";
    }

    @Override
    public int getCaliber() {
        return caliber;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }
}
