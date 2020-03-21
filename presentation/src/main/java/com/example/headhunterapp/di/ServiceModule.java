package com.example.headhunterapp.di;

import com.example.domain.service.VacanciesService;
import com.example.domain.service.VacanciesServiceImpl;

import toothpick.config.Module;


public class ServiceModule extends Module  {

/*
    ProfileServiceImpl profileService;
    ProjectServiceImpl projectService;
*/
    VacanciesServiceImpl vacanciesService;


    public ServiceModule(){

/*        bind(ProjectService.class).to(ProjectServiceImpl.class);
        bind(ProfileService.class).to(ProfileServiceImpl.class);
 */
        bind(VacanciesService.class).to(VacanciesServiceImpl.class);
    }


/*
    ProjectService provideProjectService(ProjectServiceImpl projectService) {
        return projectService;
    }
    ProfileService provideProfileService(ProfileServiceImpl profileService){
        return profileService;
    }*/
    VacanciesService provideVacanciesService(VacanciesServiceImpl vacanciesService){
        return vacanciesService;
    }

}
