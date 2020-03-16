package com.example.headhunterapp.ui.vacancies;

import androidx.fragment.app.Fragment;

import javax.inject.Inject;

public class VacanciesFragment extends Fragment {

    @Inject
    VacanciesViewModel = mVacanciesViewModel;


    public static VacanciesFragment newInstance() {
        return new VacanciesFragment();
    }
}
