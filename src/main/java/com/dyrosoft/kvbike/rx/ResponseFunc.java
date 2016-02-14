package com.dyrosoft.kvbike.rx;

import com.dyrosoft.kvbike.models.Markers;

import retrofit2.Response;
import rx.Single;
import rx.functions.Func1;

public class ResponseFunc implements Func1<Response<Markers>, Single<Markers>> {

    @Override
    public Single<Markers> call(final Response<Markers> response) {
        if (response.isSuccess()) {
            return Single.just(response.body());
        } else {
            return Single.error(new Throwable(response.message()));
        }
    }
}
