package com.example.headhunterapp.common;


import io.reactivex.disposables.CompositeDisposable;


public abstract class BasePresenter {

    protected final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void disposeAll() {
            mCompositeDisposable.dispose();
    }
}
