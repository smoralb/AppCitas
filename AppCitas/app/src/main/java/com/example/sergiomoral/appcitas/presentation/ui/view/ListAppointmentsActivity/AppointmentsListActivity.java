package com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.AppointmentsList.AppointmentsListPresenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.adapter.AppointmentListAdapter;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.rw_appointments)
    RecyclerView recyclerAppointments;

    @Inject
    AppointmentsListPresenter mPresenter;

    View guillotineMenu;
    String userToken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userToken = getIntent().getStringExtra(BuildData.USER_TOKEN);
        mPresenter.requestData(userToken);
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
        initGuillotineMenu();
        initFloatingButton();
    }

    public void initGuillotineMenu() {
        guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        LinearLayout mLogOut = (LinearLayout) findViewById(R.id.log_out);
        LinearLayout mProfile = (LinearLayout) findViewById(R.id.profile_group);
        LinearLayout mSettings = (LinearLayout) findViewById(R.id.settings_group);

        mPresenter.clickListenerProfile(mProfile);
        mPresenter.clickListenerSettings(mSettings);
        mPresenter.clickListenerLogOut(mLogOut);

        mPresenter.initGuillotineAnimation(guillotineMenu, toolbar, contentHamburger);


    }

    public void initFloatingButton() {
        //TODO: Creación de nueva cita
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_list_appointments;
    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }


    @Override
    public void showAppointments(ArrayList<Appointment> appointments) {
        recyclerAppointments.setLayoutManager(new LinearLayoutManager(this));
        AppointmentListAdapter adapter = new AppointmentListAdapter(this, appointments);
        recyclerAppointments.setAdapter(adapter);
        hideLoading();
    }
}
