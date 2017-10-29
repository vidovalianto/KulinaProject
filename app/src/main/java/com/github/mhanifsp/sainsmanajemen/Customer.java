package com.github.mhanifsp.sainsmanajemen;

/**
 * Created by Hanif on 10/26/2017.
 */
public class Customer {
    private String name;
    private double latitude;
    private double longitude;
    private int order;
    private int dapurTerdekat;
    private double prioritas;

    public Customer(String name, double latitude, double longitude, int order) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getDapurTerdekat() {
        return dapurTerdekat;
    }

    public void setDapurTerdekat(int dapurTerdekat) {
        this.dapurTerdekat = dapurTerdekat;
    }

    public double getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(double prioritas) {
        this.prioritas = prioritas;
    }
}