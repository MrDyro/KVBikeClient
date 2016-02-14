package com.dyrosoft.kvbike.models;

import com.google.common.base.Optional;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "place", strict = false)
public class Place {

    @Attribute(required = false) private Integer bike;
    @Attribute(required = false, name = "bike_numbers") private String bikeNumber;
    @Attribute private String bikes;
    @Attribute private float lat;
    @Attribute private float lng;
    @Attribute private String name;
    @Attribute(required = false) private Integer number;
    @Attribute(required = false) private Integer spot;
    @Attribute(required = false, name = "terminal_type") private String terminalType;
    @Attribute private int uid;

    public Optional<Integer> getBike() {
        return Optional.fromNullable(bike);
    }

    public Optional<String> getBikeNumber() {
        return Optional.fromNullable(bikeNumber);
    }

    public String getBikes() {
        return bikes;
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

    public Optional<Integer> getNumber() {
        return Optional.fromNullable(number);
    }

    public Optional<Integer> getSpot() {
        return Optional.fromNullable(spot);
    }

    public Optional<String> getTerminalType() {
        return Optional.fromNullable(terminalType);
    }

    public int getUid() {
        return uid;
    }
}
