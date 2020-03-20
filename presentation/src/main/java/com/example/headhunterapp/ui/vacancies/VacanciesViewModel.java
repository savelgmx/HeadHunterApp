package com.example.headhunterapp.ui.vacancies;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
//TODO write loadVacancies method
public class VacanciesViewModel {

    private Disposable mDisposable;

    @Inject
    public VacanciesViewModel(){}

    public void dispatchDetach() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }


    public void loadVacancies() {
    }
}
