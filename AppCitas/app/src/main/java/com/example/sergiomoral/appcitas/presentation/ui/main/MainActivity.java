package com.example.sergiomoral.appcitas.presentation.ui.main;


import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.ApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.ApplicationModule;

public class MainActivity extends BaseActivity {


    private ApplicationComponent mApplicationComponent;

    public void initInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(getApplication()))
                .build();
    }

    @Override
    protected void initUI() {

    }


    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void attachViewToPresenter() {

    }

}
