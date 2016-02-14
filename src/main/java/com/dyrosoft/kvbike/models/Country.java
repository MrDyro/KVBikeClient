package com.dyrosoft.kvbike.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "country", strict = false)
public class Country {

    public City getCity() {
        return city;
    }

    @Element private City city;
}
