package com.dyrosoft.kvbike.models;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "place", strict = false)
public class Place {

    public enum PlaceType {
        BIKE, SPOT, TERMINAL
    }

    @Attribute(required = false) private Integer bike;
    @Attribute(required = false, name = "bike_numbers") private String bikeNumbers;
    @Attribute private String bikes;
    @Attribute private float lat;
    @Attribute private float lng;
    @Attribute private String name;
    @Attribute(required = false) private Integer number;
    @Attribute(required = false) private Integer spot;
    @Attribute(required = false, name = "terminal_type") private String terminalType;
    @Attribute private int uid;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Place place = (Place) o;
        return Float.compare(place.lat, lat) == 0 &&
                Float.compare(place.lng, lng) == 0 &&
                uid == place.uid &&
                Objects.equal(bike, place.bike) &&
                Objects.equal(bikeNumbers, place.bikeNumbers) &&
                Objects.equal(bikes, place.bikes) &&
                Objects.equal(name, place.name) &&
                Objects.equal(number, place.number) &&
                Objects.equal(spot, place.spot) &&
                Objects.equal(terminalType, place.terminalType);
    }

    public Optional<Integer> getBike() {
        return Optional.fromNullable(bike);
    }

    public Optional<String> getBikeNumbers() {
        return Optional.fromNullable(bikeNumbers);
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

    public PlaceType getPlaceType() {
        if (bike != null && bike == 1) {
            return PlaceType.BIKE;
        } else if (spot != null && spot == 1) {
            return PlaceType.SPOT;
        } else {
            return PlaceType.TERMINAL;
        }
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

    @Override
    public int hashCode() {
        return Objects.hashCode(bike,
                                bikeNumbers,
                                bikes,
                                lat,
                                lng,
                                name,
                                number,
                                spot,
                                terminalType,
                                uid);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("bike", bike)
                .add("bikeNumbers", bikeNumbers)
                .add("bikes", bikes)
                .add("lat", lat)
                .add("lng", lng)
                .add("name", name)
                .add("number", number)
                .add("spot", spot)
                .add("terminalType", terminalType)
                .add("uid", uid)
                .toString();
    }
}
