package com.example.headhunterapp.di;

import com.example.headhunterapp.AppDelegate;
import toothpick.config.Module;

public class AppModule extends Module {
/*
    @Inject
    BehanceDao mBehanceDao;
*/

    private final AppDelegate mApp;

    public AppModule(AppDelegate mApp) {
        this.mApp = mApp;
        bind(AppDelegate.class).toInstance(provideApp());
/*
        bind(Storage.class).toInstance(provideStorage());
        bind(BehanceDao.class).toInstance(provideDao());
*/
    }


    AppDelegate provideApp() {
        return mApp;
    }

 /*   Storage provideStorage() {
        final BehanceDatabase database = Room.databaseBuilder(mApp, BehanceDatabase.class, "behance_database")
                .fallbackToDestructiveMigration()
                .build();

        return new Storage(database.getBehanceDao());
    }
    BehanceDao provideDao() {
        final BehanceDatabase database = Room.databaseBuilder(mApp, BehanceDatabase.class, "behance_database")
                .fallbackToDestructiveMigration()
                .build();

        return database.getBehanceDao();

    }
*/
}
