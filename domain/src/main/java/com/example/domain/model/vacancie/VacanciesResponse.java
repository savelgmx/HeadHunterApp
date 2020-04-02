package com.example.domain.model.vacancie;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VacanciesResponse implements Serializable {
    @SerializedName("items")
    private List<Vacancie> mVacancies;

    public List<Vacancie> getVacancies() {
        return mVacancies;
    }

    public void setVacancies(List<Vacancie> vacancies) {

        mVacancies = vacancies;

    }
}

