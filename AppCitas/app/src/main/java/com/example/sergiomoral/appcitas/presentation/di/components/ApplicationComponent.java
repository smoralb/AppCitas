package com.example.sergiomoral.appcitas.presentation.di.components;

import android.app.Application;

import com.example.sergiomoral.appcitas.presentation.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component ( modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Application app();
}

