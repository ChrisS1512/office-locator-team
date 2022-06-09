package com.solirius.hosehackathon.repository;

import com.solirius.hosehackathon.domain.Office;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfficeRepository extends CrudRepository<Office, Long> {
    List<Office> findByLatitudeAndLongitude(long latitude, long longitude);
}
