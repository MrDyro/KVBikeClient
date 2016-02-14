package com.dyrosoft.kvbike.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "city", strict = false)
public class City {

    @ElementList(inline = true) private List<Place> places;

    public List<Place> getPlaces() {
        return places;
    }
}
