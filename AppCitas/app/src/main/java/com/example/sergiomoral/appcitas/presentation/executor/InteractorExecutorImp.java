package com.example.sergiomoral.appcitas.presentation.executor;

import com.arasthel.asyncjob.AsyncJob;
import com.example.sergiomoral.appcitas.domain.interactor.BaseInteractor;
import com.example.sergiomoral.appcitas.domain.interactor.executor.InteractorExecutor;

import java.io.Serializable;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 26/2/18.
 */

public class InteractorExecutorImp implements InteractorExecutor, Serializable {

    @Inject
    public InteractorExecutorImp() {

    }

    @Override
    public void execute(final BaseInteractor baseInteractor) {
        AsyncJob.doInBackground(new AsyncJob.OnBackgroundJob() {
            @Override
            public void doOnBackground() {
                baseInteractor.run();
            }
        });
    }
}
