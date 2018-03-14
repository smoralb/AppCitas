package com.example.sergiomoral.appcitas.domain.interactor.executor;

/**
 * Created by sergiomoral on 26/2/18.
 */

public interface MainThreadExecutor {

    void execute(Runnable runnable);
}
