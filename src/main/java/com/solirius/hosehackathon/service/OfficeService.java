package com.solirius.hosehackathon.service;

import com.solirius.hosehackathon.models.Office;
import com.solirius.hosehackathon.repository.OfficeRepository;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private CsvHandlingService csvHandlingService;

    public List<Office> getOffices() {
        return IteratorUtils.toList(officeRepository.findAll().iterator());
    }

    public Office addSingleOffice(Office office) {
        return officeRepository.save(office);
    }

    public List<Office> addOfficeList(MultipartFile csvFile) throws IOException {
        return IteratorUtils.toList(officeRepository.saveAll( csvHandlingService.officesCsvToList(csvFile)).iterator());
    }
}
