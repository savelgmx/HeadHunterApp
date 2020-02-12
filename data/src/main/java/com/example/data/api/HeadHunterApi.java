package com.example.data.api;

import com.example.domain.model.vacancie.VacanciesResponse;
import com.example.domain.model.vacancie.VacanciesWithIdResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HeadHunterApi {

    //пока приложение осуществляет поиск вакансий авторизация не обязательна
    //но если понадобится то вот https://habr.com/ru/company/hh/blog/278957/
    // библиотека для работы с OAuth — ScribeJava

    @GET("/vacancies/")
    Single<VacanciesResponse> getVacancies(@Query("q") String query);

    @GET("vacancies/{vacancy_id}")
    Single<VacanciesWithIdResponse> getVacanciesWithId(@Path("vacancie_id") String vacancie_id);

}
