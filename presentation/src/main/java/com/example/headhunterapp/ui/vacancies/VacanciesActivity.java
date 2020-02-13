package com.example.headhunterapp.ui.vacancies;

import androidx.fragment.app.Fragment;

import com.example.headhunterapp.common.SingleFragmentActivity;

public class VacanciesActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() { return VacanciesFragment.newInstance();
    }
}
