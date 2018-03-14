package com.example.sergiomoral.appcitas.presentation.di.modules;

import android.os.Handler;
import android.os.Looper;

import com.example.sergiomoral.appcitas.domain.interactor.executor.InteractorExecutor;
import com.example.sergiomoral.appcitas.domain.interactor.executor.MainThreadExecutor;
import com.example.sergiomoral.appcitas.presentation.executor.InteractorExecutorImp;
import com.example.sergiomoral.appcitas.presentation.executor.MainThreadExecutorImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sergiomoral on 26/2/18.
 */

@Module
public class ExecutorModule {

    @Provides
    @Singleton
    public InteractorExecutor providesInteractroExecutor(InteractorExecutorImp interactorExecutorImp) {
        return interactorExecutorImp;
    }

    @Provides
    @Singleton
    public MainThreadExecutor providesPostExecutionThread(MainThreadExecutorImp mainThreadImp) {
        return mainThreadImp;
    }

    @Provides
    public Handler provideHandler(){
        return new Handler(Looper.getMainLooper());
    }

}
