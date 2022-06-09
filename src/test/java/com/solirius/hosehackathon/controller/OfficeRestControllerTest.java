package com.solirius.hosehackathon.controller;

import com.solirius.hosehackathon.domain.Office;
import com.solirius.hosehackathon.repository.OfficeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@WebMvcTest(OfficeRestController.class)
class OfficeRestControllerTest {

    @Autowired
    @InjectMocks
    private OfficeRestController officeRestController;

    @MockBean
    private OfficeRepository officeRepository;

    @Test
    void findAllNoRecords() {
        Mockito.when(officeRepository.findAll()).thenReturn(Collections.emptyList());
        List<Office> actualVehicleList = (List<Office>) officeRestController.findAll();
        assertNotNull(actualVehicleList);
        assertTrue(actualVehicleList.isEmpty());
    }

//    @Test
//    void findAllOneRecord() {
//        Mockito.when(officeRepository.findAll()).thenReturn(List.of(new Office(0L, 0L)));
//        List<Office> officeList = (List<Office>) officeRestController.findAll();
//        Assertions.assertEquals(1, officeList.size());
//        assertEquals(0L, officeList.get(0).getLatitude(), 0);
//    }
//
//    @Test
//    void saveVehicle() {
//        Office testOffice = new Office(0L, 0L);
//        Mockito.when(officeRepository.save(testOffice)).thenReturn(testOffice);
//        Office actualOffice = officeRestController.saveOffice(testOffice);
//        assertEquals(testOffice.getLongitude(), actualOffice.getLongitude(), 0);
//    }
//
//    @Test
//    void findByNumberPlate() {
//        Long testLat = 0L;
//        Mockito.when(officeRepository.findById(testLat)).thenReturn(Optional.of((new Office(testLat, 1L))));
//        Optional<Office> actualOffice = (Optional<Office>) officeRestController.findById(testLat);
//        assertEquals(testLat, actualOffice.get().getLatitude(), 0);
//    }
//
//
//    @Sql({"/import_number_plates.sql"})
//    void findByExternalNumberPlate() {
//
//    }
}