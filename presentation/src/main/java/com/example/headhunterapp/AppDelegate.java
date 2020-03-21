package com.example.headhunterapp;

import android.app.Application;


import com.example.headhunterapp.di.AppModule;
import com.example.headhunterapp.di.NetworkModule;
import com.example.headhunterapp.di.RepositoryModule;
import com.example.headhunterapp.di.ServiceModule;

import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.smoothie.module.SmoothieApplicationModule;

/**
 * Created by Vladislav Falzan.
 */

public class AppDelegate extends Application {

    public static Scope sAppScope;

    @Override
    public void onCreate() {
        super.onCreate();
        // Использую Toothpick 3.1
        sAppScope = Toothpick.openScope(AppDelegate.class);
        sAppScope.installModules(new SmoothieApplicationModule(this), new AppModule(this), new NetworkModule(),
                new RepositoryModule(),new ServiceModule());
    }

    public static Scope getAppScope() {
        return sAppScope;
    }
}
