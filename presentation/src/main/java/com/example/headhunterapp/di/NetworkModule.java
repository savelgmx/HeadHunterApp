package com.example.headhunterapp.di;


import com.example.headhunterapp.BuildConfig;
import com.example.data.api.ApiKeyInterceptor;
import com.example.data.api.HeadHunterApi;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import toothpick.config.Module;

public class NetworkModule extends Module  {
    private final Gson mGson = provideGson();
    private final OkHttpClient mOkHttpClient = provideClient();
    private final Retrofit mRetrofit = provideRetrofit();

    public NetworkModule() {
        bind(Gson.class).toInstance(mGson);
        bind(OkHttpClient.class).toInstance(mOkHttpClient);
        bind(Retrofit.class).toInstance(mRetrofit);
        bind(HeadHunterApi.class).toInstance(provideApiService());
    }


    OkHttpClient provideClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.addInterceptor(new ApiKeyInterceptor());
        if (!BuildConfig.BUILD_TYPE.contains("release")) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return builder.build();
    }

    Gson provideGson() {
        return new Gson();
    }

    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(com.example.data.BuildConfig.API_URL)
                // need for interceptors
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    HeadHunterApi provideApiService() {
        return mRetrofit.create(HeadHunterApi.class);
    }
}
