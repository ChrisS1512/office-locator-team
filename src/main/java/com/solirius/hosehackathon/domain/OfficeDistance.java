package com.solirius.hosehackathon.domain;

/**
 * Class which captures the office, and it's distance from the current location
 */
public class OfficeDistance {

    private Office office;

    private Double officeDistance;

    public OfficeDistance(Office office, double officeDistance) {
        this.office = office;
        this.officeDistance = officeDistance;
    }

    public Double getOfficeDistance() {
        return officeDistance;
    }

    public Office getOffice() {
        return office;
    }

}
