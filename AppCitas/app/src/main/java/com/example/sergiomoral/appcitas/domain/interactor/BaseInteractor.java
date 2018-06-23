package com.example.sergiomoral.appcitas.domain.interactor;

import com.example.sergiomoral.appcitas.domain.interactor.executor.InteractorExecutor;
import com.example.sergiomoral.appcitas.domain.interactor.executor.MainThreadExecutor;

import javax.annotation.Nonnull;

/**
 * Created by sergiomoral on 26/2/18.
 */

public abstract class BaseInteractor {

    private final InteractorExecutor mInteractorExecuter;
    private final MainThreadExecutor mMainThreadExecutor;

    public BaseInteractor(@Nonnull InteractorExecutor mInteractorExecuter, @Nonnull MainThreadExecutor mMainThreadExecutor) {

        this.mInteractorExecuter = mInteractorExecuter;
        this.mMainThreadExecutor = mMainThreadExecutor;

    }

    protected void executeInBackground() {
        mInteractorExecuter.execute(this);
    }

    protected void executeInMainThread(Runnable runnable) {
        mMainThreadExecutor.execute(runnable);
    }

    public abstract void run();

    public interface CallBack<T> {

        void onSuccess(T response);

    }
}
