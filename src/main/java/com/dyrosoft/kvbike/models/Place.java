package com.dyrosoft.kvbike.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "place", strict = false)
public class Place {

    @Attribute private int uid;
    @Attribute private float lat;
    @Attribute private float lng;
    @Attribute private String name;
    @Attribute private int spot;
    @Attribute private int number;
    @Attribute private String bikes;
    @Attribute private int bike;
    @Attribute(name = "terminal_type") private String terminalType;
    @Attribute(name = "bike_numbers") private String bikeNumber;

    public int getUid() {
        return uid;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public String getName() {
        return name;
    }

    public int getSpot() {
        return spot;
    }

    public int getNumber() {
        return number;
    }

    public String getBikes() {
        return bikes;
    }

    public int getBike() {
        return bike;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public String getBikeNumber() {
        return bikeNumber;
    }
}
