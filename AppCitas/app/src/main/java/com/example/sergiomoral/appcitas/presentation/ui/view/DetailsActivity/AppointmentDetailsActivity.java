package com.example.sergiomoral.appcitas.presentation.ui.view.DetailsActivity;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;

/**
 * Created by sergiomoral on 15/4/18.
 */

public class AppointmentDetailsActivity extends BaseActivity implements AppointmentDetailsView{


    @Override
    protected void initInjector() {
        DaggerActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected void initUI() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_appointment_details;
    }

    @Override
    public void attachViewToPresenter() {

    }
}
