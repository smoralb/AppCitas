package com.example.sergiomoral.appcitas.presentation.executor;

import com.example.sergiomoral.appcitas.domain.interactor.executor.MainThreadExecutor;

import java.io.Serializable;

import android.os.Handler;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 26/2/18.
 */

public class MainThreadExecutorImp implements MainThreadExecutor, Serializable {

    private transient Handler mHandler;

    @Inject
    public MainThreadExecutorImp(Handler handler) {
        mHandler = handler;
    }

    @Override
    public void execute(Runnable runnable) {
        mHandler.post(runnable);
    }
}
