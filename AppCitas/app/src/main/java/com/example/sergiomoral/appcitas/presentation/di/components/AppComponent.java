package com.example.sergiomoral.appcitas.presentation.di.components;

import android.app.Application;

import com.example.sergiomoral.appcitas.presentation.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component ( modules = {AppModule.class})
public interface AppComponent {

    Application app();
}

