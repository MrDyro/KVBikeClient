package com.dyrosoft.kvbike;

import com.dyrosoft.kvbike.models.City;
import com.dyrosoft.kvbike.models.Country;
import com.dyrosoft.kvbike.models.Markers;
import com.dyrosoft.kvbike.models.Place;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.net.URL;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ParsingTest {

    @Test
    public void testParsing() throws Exception {
        final Serializer serializer = new Persister();
        final URL url =
                Thread.currentThread().getContextClassLoader().getResource("testfiles/places.xml");
        final File file = new File(url.getPath());

        final Markers markers = serializer.read(Markers.class, file);
        assertThat(markers, is(notNullValue()));

        final Country country = markers.getCountry();
        assertThat(country, is(notNullValue()));

        final City city = country.getCity();
        assertThat(city, is(notNullValue()));

        final List<Place> places = city.getPlaces();
        assertThat(places, is(notNullValue()));
        assertThat(places.isEmpty(), is(not(true)));

        final Place place1 = places.get(0);
        assertThat(place1.getBike().isPresent(), is(not(true)));
        assertThat(place1.getBikeNumbers().isPresent(), is(true));
        assertThat(place1.getBikeNumbers().get(), is("21892,21301,21806,21253"));
        assertThat(place1.getBikes(), is("4"));
        assertThat(place1.getLat(), is(50.930614f));
        assertThat(place1.getLng(), is(6.940484f));
        assertThat(place1.getName(), is("Zülpicher Platz"));
        assertThat(place1.getNumber().isPresent(), is(true));
        assertThat(place1.getNumber().get(), is(4822));
        assertThat(place1.getSpot().isPresent(), is(not(true)));
        assertThat(place1.getTerminalType().isPresent(), is(true));
        assertThat(place1.getTerminalType().get(), is("free"));
        assertThat(place1.getUid(), is(22755));
        assertThat(place1.getPlaceType(), is(Place.PlaceType.TERMINAL));

        final Place place2 = places.get(4);
        assertThat(place2.getPlaceType(), is(Place.PlaceType.BIKE));

        final Place place3 = places.get(35);
        assertThat(place3.getPlaceType(), is(Place.PlaceType.SPOT));
    }
}