package com.example.sergiomoral.appcitas;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sergiomoral.appcitas.presentation.di.components.AppComponent;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerAppComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.AppModule;

public class Appointments extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
    }

    private void initInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
