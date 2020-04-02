package com.example.data.api;



import com.example.domain.model.vacancie.VacanciesResponse;
import com.example.domain.model.vacancie.VacanciesWithIdResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HeadHunterApi {

    //пока приложение осуществляет поиск вакансий авторизация не обязательна
    //но если понадобится то вот https://habr.com/ru/company/hh/blog/278957/
    // библиотека для работы с OAuth — ScribeJava

    //описание HeadHunter API здесь https://speca.io/speca/headhunter-api
    //и здесь https://github.com/hhru/api
    //GET /vacancies
    //Поиск по вакансиям
    @GET("/vacancies")
    Single<VacanciesResponse> getVacancies(@Path("text") String vacancie_text);
   // GET /vacancies/{vacancy_id}
   // возвращает подробную информацию по указанной вакансии.
    @GET("vacancies/{vacancy_id}")
    Single<VacanciesWithIdResponse> getVacanciesWithId(@Path("vacancy_id") String vacancie_id);

}
