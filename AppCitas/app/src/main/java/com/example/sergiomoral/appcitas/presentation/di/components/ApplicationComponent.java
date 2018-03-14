package com.example.sergiomoral.appcitas.presentation.di.components;

import android.app.Application;

import com.example.sergiomoral.appcitas.domain.interactor.executor.InteractorExecutor;
import com.example.sergiomoral.appcitas.domain.interactor.executor.MainThreadExecutor;
import com.example.sergiomoral.appcitas.presentation.di.modules.ApplicationModule;
import com.example.sergiomoral.appcitas.presentation.di.modules.ExecutorModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class,ExecutorModule.class})
public interface ApplicationComponent {

    Application app();

    InteractorExecutor interactorExecutor();

    MainThreadExecutor mainThreadExecutor();


}

