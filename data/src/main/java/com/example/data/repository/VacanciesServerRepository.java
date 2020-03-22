package com.example.data.repository;


import com.example.data.BuildConfig;
import com.example.data.api.HeadHunterApi;
import com.example.domain.model.vacancie.Vacancie;
import com.example.domain.model.vacancie.VacanciesResponse;
import com.example.domain.repository.VacanciesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class VacanciesServerRepository implements VacanciesRepository {

    @Inject
    HeadHunterApi mApi;
    @Inject
    public VacanciesServerRepository(){

    }


    @Override
    public Single<List<Vacancie>> getVacancies() {
        //return null;
        return mApi.getVacancies(BuildConfig.API_URL).map(new Function<VacanciesResponse,
                       List<Vacancie>>(){
            @Override
            public List<Vacancie> apply(VacanciesResponse vacanciesResponse) throws Exception{
                return vacanciesResponse.getVacancies();
            }
        });


    }

    @Override
    public void insertVacancies(List<Vacancie> vacancies) {
        //добавлен совместимости ради


    }
}
