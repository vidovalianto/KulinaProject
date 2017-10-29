package com.github.mhanifsp.sainsmanajemen;

/**
 * Created by Hanif on 10/29/2017.
 */
public class Calculator {

    static double radians(double x){
        final double PIx = 3.141592653589793;
        return x * PIx / 180;
    }

    public static double getDistance(Customer c, Dapur d){
   	    final double RADIUS = 6378.16;

        double lon1 = c.getLongitude();
        double lat1 = c.getLatitude();
        double lon2 = d.getLongitude();
        double lat2 = d.getLatitude();

        double dlon = radians(lon2 - lon1);
        double dlat = radians(lat2 - lat1);

        double a = (Math.sin(dlat / 2) * Math.sin(dlat / 2)) + Math.cos(radians(lat1)) * Math.cos(radians(lat2)) * (Math.sin(dlon / 2) * Math.sin(dlon / 2));
        double angle = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return angle * RADIUS;
    }

    public static double getDistance(Customer c, Customer d){
        final double RADIUS = 6378.16;

        double lon1 = c.getLongitude();
        double lat1 = c.getLatitude();
        double lon2 = d.getLongitude();
        double lat2 = d.getLatitude();

        double dlon = radians(lon2 - lon1);
        double dlat = radians(lat2 - lat1);

        double a = (Math.sin(dlat / 2) * Math.sin(dlat / 2)) + Math.cos(radians(lat1)) * Math.cos(radians(lat2)) * (Math.sin(dlon / 2) * Math.sin(dlon / 2));
        double angle = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return angle * RADIUS;
    }

    public static double getDistance(Dapur c, Dapur d){
        final double RADIUS = 6378.16;

        double lon1 = c.getLongitude();
        double lat1 = c.getLatitude();
        double lon2 = d.getLongitude();
        double lat2 = d.getLatitude();

        double dlon = radians(lon2 - lon1);
        double dlat = radians(lat2 - lat1);

        double a = (Math.sin(dlat / 2) * Math.sin(dlat / 2)) + Math.cos(radians(lat1)) * Math.cos(radians(lat2)) * (Math.sin(dlon / 2) * Math.sin(dlon / 2));
        double angle = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return angle * RADIUS;
    }
}
