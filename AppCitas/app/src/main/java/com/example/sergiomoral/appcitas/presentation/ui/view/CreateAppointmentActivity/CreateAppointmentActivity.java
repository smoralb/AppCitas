package com.example.sergiomoral.appcitas.presentation.ui.view.CreateAppointmentActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.createAppointment.CreateAppointmentPresenter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by sergiomoral on 9/6/18.
 */

public class CreateAppointmentActivity extends BaseActivity implements CreateAppointmentView {

    @BindView(R.id.et_service)
    EditText serviceSelected;
    @BindView(R.id.et_stablishment)
    EditText stablishmentSelected;
    @BindView(R.id.et_select_location)
    EditText locationSelected;
    @BindView(R.id.tv_select_date)
    EditText dateSelected;
    @BindView(R.id.et_select_hour)
    EditText hourSelected;

    @Inject
    CreateAppointmentPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Inject
    public CreateAppointmentActivity() {
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

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_create_appointment;
    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }
}
