package com.solirius.hosehackathon.utilities;

import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class Calculate {

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        //Calculate distance
        double latDistanceSquared = Math.pow(Math.sin(toRad(lat2 - lat1) / 2), 2);
        double lonDistanceSquared = Math.pow(Math.sin(toRad(lon2 - lon1) / 2), 2);
        double a = latDistanceSquared + Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * lonDistanceSquared;
        double c = 2 * Math.asin(Math.sqrt(a));
//        multiply by radius of the earth in km (roughly 6371km)
        return 6371.0088 * c;
    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }
}
