package com.example.headhunterapp.ui.vacancies;



import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.headhunterapp.AppDelegate;
import com.example.headhunterapp.R;

import javax.inject.Inject;

import toothpick.Toothpick;
//TODO binding error
public class VacanciesFragment extends Fragment {

    @Inject
    VacanciesViewModel mVacanciesViewModel;
    private VacanciesAdapter.OnItemClickListener mOnItemClickListener;


    public static VacanciesFragment newInstance() {
        return new VacanciesFragment();
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        Toothpick.inject(this, AppDelegate.getAppScope());

        mVacanciesViewModel.setOnItemClickListener(mOnItemClickListener);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VacanciesBinding binding = VacanciesBinding.inflate(inflater, container, false);
        binding.setVm(mVacanciesViewModel);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            getActivity().setTitle(R.string.vacancies);
        }

        mVacanciesViewModel.loadVacancies();
    }

    @Override
    public void onDetach() {
        mVacanciesViewModel.dispatchDetach();
        super.onDetach();
    }



}
