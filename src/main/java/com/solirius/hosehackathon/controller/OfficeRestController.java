package com.solirius.hosehackathon.controller;

import com.solirius.hosehackathon.domain.Office;
import com.solirius.hosehackathon.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class OfficeRestController {

    @Autowired
    private OfficeRepository officeRepository;

    @GetMapping(value = "/offices")
    public Iterable<Office> findAll() {
        return officeRepository.findAll();
    }

    @PostMapping(value= "/offices")
    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    @GetMapping(value = "/offices/{id}")
    public Optional<Office> findById(@PathVariable Long id) {
        return officeRepository.findById(id);
    }
}
