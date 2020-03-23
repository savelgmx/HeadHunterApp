package com.example.headhunterapp.di;

import com.example.data.repository.VacanciesDBRepository;
import com.example.data.repository.VacanciesServerRepository;
import com.example.domain.repository.VacanciesRepository;
import toothpick.config.Module;

public class RepositoryModule extends Module {

    public RepositoryModule(){
         bind(VacanciesRepository.class).withName(VacanciesRepository.SERVER).to(VacanciesServerRepository.class);
         bind(VacanciesRepository.class).withName(VacanciesRepository.DB).to(VacanciesDBRepository.class);
     }

    VacanciesRepository provideVacanciesServerRepository(VacanciesRepository repository) {
        return repository;
    }

    VacanciesRepository provideVacanciesDBRepository(VacanciesRepository repository) {
        return repository;
    }

}
