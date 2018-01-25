package com.example.sergiomoral.appcitas.presentation.di.modules;

import android.app.Activity;
import android.content.Context;

import com.example.sergiomoral.appcitas.presentation.di.quialifiers.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sergiomoral on 31/12/17.
 */

@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    public Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    Activity providesActivity() {
        return mActivity;
    }
}
