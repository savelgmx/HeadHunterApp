package com.example.headhunterapp.ui.vacancies;

import com.example.domain.Vacancie;
import com.example.headhunterapp.common.BaseView;

import java.util.List;

public interface VacanciesView extends BaseView {
 void showVacancies(List<Vacancie> vacancies);
}
