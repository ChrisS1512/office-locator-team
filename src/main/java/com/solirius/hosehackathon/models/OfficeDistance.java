package com.solirius.hosehackathon.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class which captures the office, and it's distance from the current location
 */
@Data
@AllArgsConstructor
public class OfficeDistance {

    private Office office;

    private Double officeDistance;
}
