package com.example.data.api;

import com.example.domain.model.vacancie.VacanciesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HeadHunterApi {

    @GET("/vacancies/")
    Single<VacanciesResponse> getVacancies(@Query("q") String query);

}
