package com.example.sergiomoral.appcitas;

import android.app.Application;

import com.example.sergiomoral.appcitas.presentation.di.components.ApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.ApplicationModule;

/**
 * Created by sergiomoral on 25/1/18.
 */

public class Appointments extends Application{

    private ApplicationComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        initInjector();
    }

    private void initInjector() {
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


    public ApplicationComponent getAppComponent(){
        return mAppComponent;
    }
}
