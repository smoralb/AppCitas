package com.example.sergiomoral.appcitas;

import android.app.Application;
import android.graphics.Typeface;

import com.example.sergiomoral.appcitas.presentation.di.components.ApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.ApplicationModule;


/**
 * Created by sergiomoral on 25/1/18.
 */

public class Appointments extends Application {

    private ApplicationComponent mAppComponent;

    private static final String CANARO_EXTRA_BOLD_PATH = "fonts/canaro_extra_bold.otf";
    public static Typeface canaroExtraBold;


    @Override
    public void onCreate() {
        super.onCreate();

        initInjector();
        initTypeface();

    }

    private void initInjector() {
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void initTypeface() {
        canaroExtraBold = Typeface.createFromAsset(getAssets(), CANARO_EXTRA_BOLD_PATH);

    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }
}
