package com.example.sergiomoral.appcitas.presentation.ui.presenter.AppointmentsList;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.domain.exceptions.BaseException;
import com.example.sergiomoral.appcitas.domain.interactor.BaseInteractor;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.AppointmentsListView;
import com.google.firebase.auth.FirebaseAuth;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by sergiomoral on 8/2/18.
 */

public class AppointmentsListPresenter implements Presenter<AppointmentsListView> {

    //TODO: Mandar a Constants
    private static final long RIPPLE_DURATION = 250;

    private AppointmentsListView mView;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    List<Appointment> mAppointments;


    @Inject
    public AppointmentsListPresenter() {
    }


    public List<Appointment> getAppointments(){
        return mAppointments;
    }

    @Override
    public void attachView(AppointmentsListView view) {
        mView = view;
    }

    public void initGuillotineAnimation(View guillotineMenu, Toolbar toolbar, View contentHamburger) {

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }

    public void clickListenerLogOut(LinearLayout logOut) {

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                mView.goToLogin();
            }
        });
    }

    public void clickListenerProfile(LinearLayout profile) {

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // your action

            }
        });
    }


    public void clickListenerSettings(LinearLayout settings) {

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // your action

            }
        });
    }

    private void showLoading() {
        if (mView != null) {
            mView.showLoading();
        }
    }

}
