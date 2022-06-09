package com.solirius.hosehackathon.repository;

import com.solirius.hosehackathon.domain.Office;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class OfficeRepositoryTest {

    @Autowired
    private OfficeRepository officeRepository;

//    @Test
//    void saveVehicle() {
//        Office testOffice = new Office(0L, 0L);
//        officeRepository.save(testOffice);
//        Optional<Office> actualOffice = officeRepository.findById(1L);
//        assertTrue(actualOffice.isPresent());
//        assertEquals(0L, actualOffice.get().getLatitude());
//    }
//
//    @Test
//    void findVehicleByNumberPlateOneRecord() {
//        Office testOffice = new Office(0L, 0L);
//        officeRepository.save(testOffice);
//        List<Office> actualVehicle = officeRepository.findByLatitudeAndLongitude(0L, 0L);
//        assertEquals(1, actualVehicle.size());
//    }
//
//    @Test
//    void findVehicleByNumberPlateNoRecord() {
//        List<Office> actualOfficeList = officeRepository.findByLatitudeAndLongitude(0L, 0L);
//        assertEquals(0, actualOfficeList.size());
//    }

}