package com.example.sergiomoral.appcitas.presentation.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sergiomoral.appcitas.presentation.di.components.ApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.appcitas.presentation.ui.view.BaseView;


import butterknife.ButterKnife;

/**
 * Created by sergiomoral on 10/1/18.
 */

public abstract class BaseActivity extends Activity implements BaseView {


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
        //attachViewToPresenter();
        initUI();
    }

    protected ApplicationComponent getAppComponent() {
        return getAppComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    //protected abstract void attachViewToPresenter();

    protected abstract void initInjector();

    protected abstract void initUI();

    public abstract int getLayoutId();
}