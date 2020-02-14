package com.example.domain.service;

import com.example.domain.ApiUtils;
import com.example.domain.model.vacancie.Vacancie;
import com.example.domain.repository.VacanciesRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


import io.reactivex.Single;

public class VacanciesServiceImpl implements VacanciesService {
    @Inject
    @Named(VacanciesRepository.SERVER)
    VacanciesRepository mServerRepository;
    @Inject
    @Named(VacanciesRepository.DB)
    VacanciesRepository mDBRepository;

    @Inject
    public VacanciesServiceImpl(){

    }


    @Override
    public Single<List<Vacancie>> getVacancies() {
        return mServerRepository.getVacancies()
                .doOnSuccess(mDBRepository::insertVacancies)
                .onErrorReturn(throwable ->
                        ApiUtils.NETWORK_EXCEPTIONS.contains(throwable.getClass())
                                ? mDBRepository.getVacancies().blockingGet()
                                : null);
    }

    @Override
    public void insertVacancies(List<Vacancie> vacancies) {
        mDBRepository.insertVacancies(vacancies);
    }

}
