package com.solirius.hosehackathon.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Office {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private double latitude;

    private double longitude;

    private String name;

    private boolean wifi;

    private boolean extendedAccess;

    private boolean meetingRooms;

    private boolean kitchen;

    private boolean breakArea;

    private boolean petFriendly;

    private boolean printing;

    private boolean shower;


    public Office(OfficeCsv officeCsv) {
        this.latitude = officeCsv.getLatitude();
        this.longitude = officeCsv.getLongitude();
        this.name = officeCsv.getName();
        this.wifi = officeCsv.isWifi();
        this.extendedAccess = officeCsv.isExtendedAccess();
        this.meetingRooms = officeCsv.isMeetingRooms();
        this.kitchen = officeCsv.isKitchen();
        this.breakArea = officeCsv.isBreakArea();
        this.petFriendly = officeCsv.isPetFriendly();
        this.printing = officeCsv.isPrinting();
        this.shower = officeCsv.isShower();
    }
}
