package com.solirius.hosehackathon.service;

import com.solirius.hosehackathon.models.Office;
import com.solirius.hosehackathon.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    public String addSingleOffice(Office office) {
        officeRepository.save(office);
        return "Saved";
    }

    public String addOfficeList() {
        // Need to loop through
        return "OK";
    }
}
