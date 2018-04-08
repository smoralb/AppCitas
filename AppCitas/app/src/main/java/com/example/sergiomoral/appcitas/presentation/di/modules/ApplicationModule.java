package com.example.sergiomoral.appcitas.presentation.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.sergiomoral.appcitas.presentation.utils.constants.ErrorHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sergiomoral on 18/11/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplicationContext() {
        return mApplication;
    }

    @Provides
    SharedPreferences providesSharedPreferences() {
        return mApplication.getSharedPreferences("user-prefs", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public ErrorHelper provideErrorHelper(Application application) {
        return new ErrorHelper(application);
    }

}
