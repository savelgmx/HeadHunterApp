package com.example.data;


import com.example.data.database.HeadHunterDao;
import com.example.domain.model.vacancie.Vacancie;
import com.example.domain.model.vacancie.VacanciesResponse;
import java.util.List;


public class Storage {


    private HeadHunterDao mHeadHunterDao;

    public Storage(HeadHunterDao headHunterDao) {
        mHeadHunterDao = headHunterDao;
    }

    public void insertVacancies(VacanciesResponse response) {
        List<Vacancie> vacancies = response.getVacancies();
        mHeadHunterDao.insertVacancies(vacancies);
    }


    public VacanciesResponse getVacancies() {
        List<Vacancie> vacancies = mHeadHunterDao.getVacancies();
        for (Vacancie vacancie : vacancies) {
        }

        VacanciesResponse response = new VacanciesResponse();
        response.setVacancies(vacancies);

        return response;
    }


}
