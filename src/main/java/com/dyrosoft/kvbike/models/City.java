package com.dyrosoft.kvbike.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "city", strict = false)
public class City {

    public List<Place> getPlaces() {
        return places;
    }

    @ElementList(name="place") private List<Place> places;
}
