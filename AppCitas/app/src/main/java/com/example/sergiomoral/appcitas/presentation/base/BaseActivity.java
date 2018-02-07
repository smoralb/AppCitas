package com.example.sergiomoral.appcitas.presentation.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sergiomoral.appcitas.Appointments;
import com.example.sergiomoral.appcitas.presentation.di.components.ApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;
import com.example.sergiomoral.appcitas.presentation.ui.view.BaseView;
import com.google.firebase.auth.FirebaseAuth;


import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by sergiomoral on 10/1/18.
 */

public abstract class BaseActivity extends Activity implements BaseView {


    @Inject
    DialogManager mDialogManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        int layoutId = getLayoutId();
        if (layoutId != 0) {
            setContentView(layoutId);
            ButterKnife.bind(this);
        }

        initInjector();
        attachViewToPresenter();
        initUI();
    }


    protected ApplicationComponent getAppComponent() {
        return ((Appointments) getApplication()).getAppComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected abstract void initInjector();

    protected abstract void initUI();

    public abstract int getLayoutId();

    public abstract void attachViewToPresenter();

    @Override
    public void showLoading() {
        mDialogManager.showLoading();
    }

    @Override
    public void hideLoading() {
        mDialogManager.hideLoading();
    }
}
