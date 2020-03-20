package com.example.headhunterapp.ui.vacancies;

import com.example.domain.model.vacancie.Vacancie;
import com.example.headhunterapp.common.BaseView;

import java.util.List;

public interface VacanciesView extends BaseView {
 void showVacancies(List<Vacancie> vacancies);
}
