package com.example.sergiomoral.appcitas.presentation.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by sergiomoral on 18/11/17.
 */

public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
}
