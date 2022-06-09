package com.solirius.hosehackathon.service;

import com.solirius.hosehackathon.models.Office;
import com.solirius.hosehackathon.models.OfficeDistance;
import com.solirius.hosehackathon.repository.OfficeRepository;
import com.solirius.hosehackathon.utilities.Calculate;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private CsvHandlingService csvHandlingService;

    @Autowired
    Calculate calculate;

    /**
     * Add a single office to the database
     *
     * @param office The office to save in the database
     * @return The office that has been added
     */
    public Office addSingleOffice(Office office) {
        return officeRepository.save(office);
    }

    /**
     * Add a csv list of offices to the database
     *
     * @param csvFile The csv file containing the list of offices
     * @return A list of the offices that have been added
     * @throws IOException
     */
    public List<Office> addOfficeList(MultipartFile csvFile) throws IOException {
        return IteratorUtils.toList(officeRepository.saveAll( csvHandlingService.officesCsvToList(csvFile)).iterator());
    }

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
