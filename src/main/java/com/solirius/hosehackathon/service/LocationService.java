package com.solirius.hosehackathon.service;

import com.solirius.hosehackathon.models.Office;
import com.solirius.hosehackathon.models.OfficeDistance;
import com.solirius.hosehackathon.repository.OfficeRepository;
import com.solirius.hosehackathon.utilities.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class LocationService {

    @Autowired
    Calculate calculate;

    @Autowired
    OfficeRepository officeRepository;

    /**
     * Takes in a latitude and longitude of the current location, and returns the nearest office.
     *
     * @param latitude The latitude of the current location.
     * @param longitude The longitude of the current location.
     */
    public OfficeDistance calculateLocation(double latitude, double longitude) {
        Iterable<Office> offices = officeRepository.findAll();

        List<OfficeDistance> officeDistanceList = StreamSupport.stream(offices.spliterator(), false)
                .map((office) ->
                        new OfficeDistance(office,
                                calculate.distance(latitude, longitude, office.getLatitude(), office.getLongitude()))
                ).sorted(Comparator.comparing(OfficeDistance::getOfficeDistance)).collect(Collectors.toList());

        return officeDistanceList.get(0);
    }


}
