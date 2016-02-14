package com.dyrosoft.kvbike;

import com.dyrosoft.kvbike.models.Place;
import com.google.common.collect.ImmutableList;

import org.junit.Test;

import rx.schedulers.Schedulers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class KvbikeClientTest {

    @Test
    public void testParsing() throws Exception {
        final KvbikeClient client = new KvbikeClient();
        final ImmutableList<Place> places = client.fetchAllPlaces()
                .subscribeOn(Schedulers.immediate())
                .observeOn(Schedulers.immediate())
                .toBlocking()
                .value();
        assertThat(places.isEmpty(), is(not(true)));
    }
}