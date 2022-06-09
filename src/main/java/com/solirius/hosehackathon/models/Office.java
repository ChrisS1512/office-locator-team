package com.solirius.hosehackathon.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
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
}
