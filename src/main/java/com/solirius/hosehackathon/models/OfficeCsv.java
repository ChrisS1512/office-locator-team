package com.solirius.hosehackathon.models;


import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class OfficeCsv {

    @CsvBindByPosition(position = 0)
    private double latitude;

    @CsvBindByPosition(position = 1)
    private double longitude;

    @CsvBindByPosition(position = 2)
    private String name;

    @CsvBindByPosition(position = 3)
    private boolean wifi;

    @CsvBindByPosition(position = 4)
    private boolean extendedAccess;

    @CsvBindByPosition(position = 5)
    private boolean meetingRooms;

    @CsvBindByPosition(position = 6)
    private boolean kitchen;

    @CsvBindByPosition(position = 7)
    private boolean breakArea;

    @CsvBindByPosition(position = 8)
    private boolean petFriendly;

    @CsvBindByPosition(position = 9)
    private boolean printing;

    @CsvBindByPosition(position = 10)
    private boolean shower;
}
