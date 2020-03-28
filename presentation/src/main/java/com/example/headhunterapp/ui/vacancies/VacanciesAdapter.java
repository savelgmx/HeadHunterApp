package com.example.headhunterapp.ui.vacancies;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.domain.model.vacancie.Vacancie;

import java.util.List;


public class VacanciesAdapter extends RecyclerView.Adapter<VacanciesHolder> {
    @NonNull
    private final List<Vacancie> mVacansies;
    private final OnItemClickListener mOnItemClickListener;

    public VacanciesAdapter(@NonNull List<Vacancie> Vacansies, OnItemClickListener onItemClickListener) {
        mVacansies = Vacansies;
        this.mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public VacanciesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VacanciesHolder holder, int position) {
        Vacancie vacancie = mVacansies.get(position);
        holder.bind(vacancie, mOnItemClickListener);

    }

    @Override
    public int getItemCount() {
        return mVacansies.size();
    }

    public void addData(List<Vacancie> data, boolean isRefreshed) {
        if (isRefreshed) {
           mVacansies.clear();
        }

       mVacansies.addAll(data);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {

        void onItemClick();
    }
}
