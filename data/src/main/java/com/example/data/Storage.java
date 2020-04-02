package com.example.data;


import android.support.v4.util.Pair;
import com.example.data.database.HeadHunterDao;
import com.example.domain.model.vacancie.Area;
import com.example.domain.model.vacancie.Salary;
import com.example.domain.model.vacancie.Vacancie;
import com.example.domain.model.vacancie.VacanciesResponse;

import java.util.ArrayList;
import java.util.List;


public class Storage {

//TODO area salary fill in getVacancies()

    private HeadHunterDao mHeadHunterDao;

    public Storage(HeadHunterDao headHunterDao) {
        mHeadHunterDao = headHunterDao;
    }




    public void insertVacancies(VacanciesResponse response) {
        List<Vacancie> vacancies = response.getVacancies();
        mHeadHunterDao.insertVacancies(vacancies);

        Pair<List<Area>,List<Salary>> assembled = assemble(vacancies);
        mHeadHunterDao.clearAreaTable();
        mHeadHunterDao.insertArea();
        mHeadHunterDao.clearSalaryTable();
        mHeadHunterDao.insertSalary();

    }

    private Pair<List<Area>, List<Salary>> assemble(List<Vacancie> vacancies) {

        List<Area> areas = new ArrayList<>();
        List<Salary> salaries = new ArrayList<>();
        for (int i = 0; i < vacancies.size(); i++) {
            Area area = (Area) vacancies.get(i).getArea();
            area.setId(String.valueOf(i));
            area.setVacancieId(vacancies.get(i).getId());
            areas.add(area);

            Salary salary = vacancies.get(i).getSalary().get(0);
            salary.setId(i);
            salary.setVacancieId(vacancies.get(i).getId());
            salaries.add(salary);
        }
        return new Pair<>(areas, salaries);



    }


    public VacanciesResponse getVacancies() {
        List<Vacancie> vacancies = mHeadHunterDao.getVacancies();
        for (Vacancie vacancie : vacancies) {
            //здесь в цикле должнв заполняться таблицы для Area и Salary

        }

        VacanciesResponse response = new VacanciesResponse();
        response.setVacancies(vacancies);

        return response;
    }


}
