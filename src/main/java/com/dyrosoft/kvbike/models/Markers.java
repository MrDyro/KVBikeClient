package com.dyrosoft.kvbike.models;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "markers", strict = false)
public class Markers {

    @Element private Country country;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Markers markers = (Markers) o;
        return Objects.equal(country, markers.country);
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(country);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("country", country)
                .toString();
    }
}
