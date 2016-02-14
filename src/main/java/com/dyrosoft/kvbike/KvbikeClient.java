package com.dyrosoft.kvbike;

import com.dyrosoft.kvbike.api.ApiProvider;
import com.dyrosoft.kvbike.api.NextBikeApi;
import com.dyrosoft.kvbike.models.Markers;
import com.dyrosoft.kvbike.models.Place;
import com.dyrosoft.kvbike.rx.ResponseFunc;
import com.google.common.collect.ImmutableList;

import rx.Single;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class KvbikeClient {

    private static final int KVBIKE_ID = 14;

    private final NextBikeApi api;
    private final ResponseFunc responseFunc;

    public KvbikeClient() {
        api = ApiProvider.getNextBikeApi();
        responseFunc = new ResponseFunc();
    }

    public Single<ImmutableList<Place>> fetchAllPlaces() {
        return api.queryAll(KVBIKE_ID)
                .flatMap(responseFunc)
                .flatMap(new Func1<Markers, Single<ImmutableList<Place>>>() {
                    @Override
                    public Single<ImmutableList<Place>> call(final Markers markers) {
                        return Single.just(ImmutableList.copyOf(markers.getCountry()
                                                                        .getCity()
                                                                        .getPlaces()));
                    }
                })
                .subscribeOn(Schedulers.io());
    }
}
