package com.dyrosoft.kvbike.api;

import com.dyrosoft.kvbike.models.Markers;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Single;

public interface NextBikeApi {

    @GET("maps/nextbike-live.xml")
    Single<Response<Markers>> queryAll(@Query("city") final int cityId);
}
