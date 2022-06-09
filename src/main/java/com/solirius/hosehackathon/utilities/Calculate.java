package com.solirius.hosehackathon.utilities;

import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class Calculate {

    /**
     * @param milesDistance
     * @param duration
     * @return the resulting speed as milesDistance/hour
     */
    public static double speed(double milesDistance, Duration duration) {
        //Calculate speed
        return 0;
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        //Calculate distance
        Double latDistanceSquared = Math.pow(Math.sin(toRad(lat2 - lat1) / 2), 2);
        Double lonDistanceSquared = Math.pow(Math.sin(toRad(lon2 - lon1) / 2), 2);
        Double a = latDistanceSquared + Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * lonDistanceSquared;
        Double c = 2 * Math.asin(Math.sqrt(a));
//        multiply by radius of the earth in km (roughly 6371km)
        return 6371.0088 * c;
    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }
}
