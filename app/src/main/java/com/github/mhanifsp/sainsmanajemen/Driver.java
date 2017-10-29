package com.github.mhanifsp.sainsmanajemen;

import java.util.List;

/**
 * Created by VidoValianto on 10/29/17.
 */

public class Driver {
    public List<Customer> customers;
    public long totalDistance;
    private final int maxBox = 40;
    public int Box =0;

    public int getMaxBox() {
        return maxBox;
    }

    public int getBox() {
        return Box;
    }

    public void setBox(int box) {
        Box = box;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public long getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(long totalDistance) {
        this.totalDistance = totalDistance;
    }
}
