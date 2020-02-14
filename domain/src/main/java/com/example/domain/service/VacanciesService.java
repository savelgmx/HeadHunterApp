package com.example.domain.service;

import com.example.domain.model.vacancie.Vacancie;

import java.util.List;

import io.reactivex.Single;

public interface VacanciesService {
    Single<List<Vacancie>> getVacancies();
    void insertVacancies(List<Vacancie>vacancies);
}
