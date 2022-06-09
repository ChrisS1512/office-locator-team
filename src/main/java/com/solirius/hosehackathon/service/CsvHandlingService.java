package com.solirius.hosehackathon.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.solirius.hosehackathon.errorhandling.CsvHandlingException;
import com.solirius.hosehackathon.models.Office;
import com.solirius.hosehackathon.models.OfficeCsv;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvHandlingService {

    /**
     * Handle an incoming csv file and transform it into a list of offices
     *
     * @param officesCsv The office csv to convert
     * @return A list of offices
     */
    public List<Office> officesCsvToList(MultipartFile officesCsv) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(officesCsv.getInputStream());
            Reader reader = new BufferedReader(inputStreamReader)) {

            CsvToBean<OfficeCsv> csvToBean = new CsvToBeanBuilder<OfficeCsv>(reader)
                    .withType(OfficeCsv.class)
                    .build();

            return csvToBean.parse().stream()
                    .map(Office::new).collect(Collectors.toList());

        } catch (IOException ioException) {
            throw new CsvHandlingException("Unable to parse csv file");
        }
    }
}
