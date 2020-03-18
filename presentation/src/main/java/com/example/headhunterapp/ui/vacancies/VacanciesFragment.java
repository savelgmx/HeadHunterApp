package com.example.headhunterapp.ui.vacancies;



import android.support.v4.app.Fragment;

import javax.inject.Inject;

public class VacanciesFragment extends Fragment {

    @Inject
    VacanciesViewModel mVacanciesViewModel;


    public static VacanciesFragment newInstance() {
        return new VacanciesFragment();
    }
}
