package com.github.mhanifsp.sainsmanajemen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanif on 10/29/2017.
 */
public class Dapur {
    private String name;		// Nama costumer
    private double latitude;	// Latitude
    private double longitude;	// Longitude
    private int minOrder;   		// Minimal order
    private int maxOrder;   		// Maxorder
    private List<Customer> listCustomer = new ArrayList<>();

    public Dapur(String name, double latitude, double longitude, int minOrder, int maxOrder) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.minOrder = minOrder;
        this.maxOrder = maxOrder;
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

    public int getMinOrder() {
        return minOrder;
    }

    public void setMinOrder(int minOrder) {
        this.minOrder = minOrder;
    }

    public int getMaxOrder() {
        return maxOrder;
    }

    public void setMaxOrder(int maxOrder) {
        this.maxOrder = maxOrder;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCusstomer) {
        this.listCustomer = listCusstomer;
    }

    public void addCustomerToList(Customer c){
        listCustomer.add(c);
    }
}
