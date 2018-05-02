package com.example.sergiomoral.appcitas.presentation.ui.view.SplashActivity;

import android.content.Context;
import android.content.Intent;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Splash.SplashScreenPresenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.NetworkErrorActivity.NetworkErrorActivity;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;


/**
 * Created by sergiomoral on 12/11/17.
 */

public class SplashScreenActivity extends BaseActivity implements SplashScreenView {

    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Inject
    SplashScreenPresenter mSplashPresenter;

    private Context context;

    @Inject
    public SplashScreenActivity() {
    }

    @Override
    protected void initInjector() {
        DaggerActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected void initUI() {

        context = this;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (checkConnectivity(context)) {
                    goToLogin();
                } else {
                    goToNetWorkError();
                }
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }


    @Override
    public int getLayoutId() {
        return R.layout.splash_screen;
    }

    @Override
    public void attachViewToPresenter() {
        mSplashPresenter.attachView(this);
    }

    @Override
    public void goToNetWorkError() {
        Intent networkError = new Intent().setClass(
                this, NetworkErrorActivity.class);
        startActivity(networkError);
    }


}
