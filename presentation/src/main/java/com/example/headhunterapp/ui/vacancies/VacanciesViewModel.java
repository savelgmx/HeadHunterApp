package com.example.headhunterapp.ui.vacancies;


import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.support.v4.widget.SwipeRefreshLayout;

import com.example.domain.model.vacancie.Vacancie;
import com.example.domain.service.VacanciesService;
import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VacanciesViewModel {

    @Inject
    VacanciesService mService;

    private Disposable mDisposable;
    private VacanciesAdapter.OnItemClickListener mOnItemClickListener;
    private ObservableBoolean mIsErrorVisible = new ObservableBoolean(false);
    private ObservableBoolean mIsLoading = new ObservableBoolean(false);
    private ObservableArrayList<Vacancie> mVacancies = new ObservableArrayList<>();
    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = this::loadVacancies;

    @Inject
    public VacanciesViewModel(){

    }


    public void loadVacancies() {
        //здесь добавляем код для загрузки
        // списка вакансий с удаленного сервера
        mDisposable = mService.getVacancies()
                .doOnSuccess(response -> mService.insertVacancies(response))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mIsLoading.set(true))
                .doFinally(() -> mIsLoading.set(false))
                .subscribe(
                        response -> {
                            mIsErrorVisible.set(false);
                            mProjects.addAll(response);
                        },
                        throwable -> mIsErrorVisible.set(true));

    }

    public void dispatchDetach() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
    public VacanciesAdapter.OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setOnItemClickListener(VacanciesAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public ObservableBoolean getIsErrorVisible() {
        return mIsErrorVisible;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public ObservableArrayList<Vacancie> getVacancies() {
        return mVacancies;
    }

    public SwipeRefreshLayout.OnRefreshListener getOnRefreshListener() {
        return mOnRefreshListener;
    }

}
