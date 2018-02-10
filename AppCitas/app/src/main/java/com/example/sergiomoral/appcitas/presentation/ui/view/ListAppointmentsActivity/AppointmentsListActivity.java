package com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.AppointmentsList.AppointmentsListPresenter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by sergiomoral on 8/2/18.
 */

public class AppointmentsListActivity extends BaseActivity implements AppointmentsListView {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.root)
    FrameLayout root;
    @BindView(R.id.content_hamburger)
    View contentHamburger;

    @Inject
    AppointmentsListPresenter mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        LinearLayout mLogOut = (LinearLayout) findViewById(R.id.log_out);
        LinearLayout mProfile = (LinearLayout) findViewById(R.id.profile_group);
        LinearLayout mSettings = (LinearLayout) findViewById(R.id.settings_group);

        mPresenter.clickListenerProfile(mProfile);
        mPresenter.clickListenerSettings(mSettings);
        mPresenter.clickListenerLogOut(mLogOut);

        mPresenter.initGuillotineAnimation(guillotineMenu, toolbar, contentHamburger);


    }

    @Inject
    public AppointmentsListActivity() {

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
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_list_appointments;
    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }
}
