package com.example.headhunterapp.di;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.example.data.Storage;
import com.example.data.database.HeadHunterDao;
import com.example.data.database.HeadHunterDatabase;
import com.example.headhunterapp.AppDelegate;

import javax.inject.Inject;

import toothpick.config.Module;

public class AppModule extends Module {
    @Inject
    HeadHunterDao mHeadHunterDao;

    private final AppDelegate mApp;

    public AppModule(AppDelegate mApp) {
        this.mApp = mApp;
        bind(AppDelegate.class).toInstance(provideApp());
        bind(Storage.class).toInstance(provideStorage());
        bind(HeadHunterDao.class).toInstance(provideDao());
    }

    Storage provideStorage() {
        final HeadHunterDatabase database = Room.databaseBuilder(mApp,HeadHunterDatabase.class,"headhunter_database")
                .fallbackToDestructiveMigration()
                .build();
        return new Storage(database.getHeadHunterDao());


    }

     HeadHunterDao provideDao() {
        final HeadHunterDatabase database = Room.databaseBuilder(mApp,HeadHunterDatabase.class,"headhunter_database")
                .fallbackToDestructiveMigration()
                .build();
        return database.getHeadHunterDao();
    }


    AppDelegate provideApp() {
        return mApp;
    }

}
