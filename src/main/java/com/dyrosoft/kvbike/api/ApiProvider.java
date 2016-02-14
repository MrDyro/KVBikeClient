package com.dyrosoft.kvbike.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public final class ApiProvider {

    private static final String BASE_URL = "http://www.api.nextbike.net/";

    private ApiProvider() {
    }

    public static NextBikeApi getNextBikeApi() {
        return buildRetrofit().create(NextBikeApi.class);
    }

    private static Retrofit buildRetrofit() {
        final OkHttpClient client = new OkHttpClient();
        final String endpoint = BASE_URL;

        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }
}
