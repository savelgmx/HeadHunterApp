package com.example.data.repository;


import com.example.domain.model.vacancie.Vacancie;
import com.example.domain.repository.VacanciesRepository;
import com.example.data.database.HeadHunterDao;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class VacanciesDBRepository implements VacanciesRepository {

    @Inject
    HeadHunterDao mHeadHunterDao;

    @Override
    public Single<List<Vacancie>> getVacancies() {
        return null;
    }

    @Override
    public void insertVacancies(List<Vacancie> vacancies) {

    }
}
