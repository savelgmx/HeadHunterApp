package com.example.headhunterapp.ui.vacancies;

import android.text.format.DateUtils;

import com.example.domain.model.vacancie.Vacancie;

public class VacancieListItemViewModel {
//    private static final int FIRST_OWNER_INDEX = 0;

    private String mImageUrl;
    private String mName;
    private String mUsername;
    private String mPublishedOn;

    public VacancieListItemViewModel(Vacancie vacancie) {
        mImageUrl = null;//vacancie.getCover().getPhotoUrl();
        mName = vacancie.getName();
        mUsername = null; //vacancie.getOwners().get(FIRST_OWNER_INDEX).getUsername();
        mPublishedOn = null;//DateUtils.format(vacancie.getPublishedOn());

    }


    public String getImageUrl() {
        return mImageUrl;
    }

    public String getName() {
        return mName;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getPublishedOn() {
        return mPublishedOn;
    }
}
