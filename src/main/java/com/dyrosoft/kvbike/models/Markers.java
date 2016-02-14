package com.dyrosoft.kvbike.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "markers", strict = false)
public class Markers {

    public Country getCountry() {
        return country;
    }

    @Element private Country country;
}
