package com.example.sergiomoral.appcitas;

import android.app.Application;

import com.example.sergiomoral.appcitas.presentation.di.components.ApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.ApplicationModule;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by sergiomoral on 25/1/18.
 */

public class Appointments extends Application {

    private ApplicationComponent mAppComponent;


    //Entry point to acces from the app to the database
    private FirebaseDatabase mFirebaseDatabase;
    //Object reference of a specific part of database
    private DatabaseReference mDatabaseReference;


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

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }
}
