package com.dyrosoft.kvbike.models;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "country", strict = false)
public class Country {

    @Element private City city;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Country country = (Country) o;
        return Objects.equal(city, country.city);
    }

    public City getCity() {
        return city;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(city);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("city", city)
                .toString();
    }
}
