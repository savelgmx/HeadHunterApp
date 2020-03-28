package com.example.headhunterapp.ui.vacancies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.domain.model.vacancie.Vacancie;
import com.example.headhunterapp.databinding.VacanciesBinding;


class VacanciesHolder extends RecyclerView.ViewHolder {

     VacanciesBinding mVacanciesBinding;

    public VacanciesHolder(VacanciesBinding binding) {
        super(binding.getRoot());
        mVacanciesBinding =binding;
    }

    public void bind(Vacancie item, VacanciesAdapter.OnItemClickListener onItemClickListener) {

        mVacanciesBinding.setVacancie(new VacancieListItemViewModel(item));
        mVacanciesBinding.setOnItemClickListener(onItemClickListener);
        mVacanciesBinding.executePendingBindings(); // Заставляет сделать связывание сразу, как только метод был вызван.

    }
}
