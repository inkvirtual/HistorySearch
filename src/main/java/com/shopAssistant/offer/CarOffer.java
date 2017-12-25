package com.shopAssistant.offer;

/**
 * Created by fanta on 7/3/17.
 */
public class CarOffer extends AbstractOffer {
    private String manufacturer;
    private String model;
    private Integer year;
    private Integer mileage;

    public CarOffer() {
        super();
        manufacturer = null;
        model = null;
        year = null;
        mileage = null;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}
