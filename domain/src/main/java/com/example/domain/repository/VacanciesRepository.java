package com.example.domain.repository;

import java.util.List;

public interface VacanciesRepository {

    String SERVER ="SERVER";//строка запроса к удаленному серверу через HeadHunter API
    String DB ="DB";//будем кэшировать запрос в локальной БД вроде Room

    Single<List<Vacancie>> getVacancies();
    void insertVacancies(List<Vacancie> vacancies);

}
