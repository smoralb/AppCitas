package com.example.sergiomoral.appcitas.presentation.ui.presenter.Splash;

import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.SplashActivity.SplashScreenView;


import javax.inject.Inject;

/**
 * Created by sergiomoral on 7/2/18.
 */

public class SplashScreenPresenter implements Presenter<SplashScreenView> {

    private SplashScreenView mView;

    @Inject
    public SplashScreenPresenter() {

    }

    @Override
    public void attachView(SplashScreenView view) {
        mView = view;
    }
}
