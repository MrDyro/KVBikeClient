package com.dyrosoft.kvbike.models;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "city", strict = false)
public class City {

    @ElementList(inline = true) private List<Place> places;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final City city = (City) o;
        return Objects.equal(places, city.places);
    }

    public List<Place> getPlaces() {
        return places;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(places);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("places", places)
                .toString();
    }
}
