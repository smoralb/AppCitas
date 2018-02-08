package com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.AppointmentsList.AppointmentsListPresenter;
import com.yalantis.guillotine.animation.GuillotineAnimation;

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

    private static final long RIPPLE_DURATION = 250;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
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
