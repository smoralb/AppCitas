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


/**
 * Created by sergiomoral on 8/2/18.
 */

public class AppointmentsListPresenter implements Presenter<AppointmentsListView> {

    //TODO: Mandar a Constants
    private static final long RIPPLE_DURATION = 250;

    private AppointmentsListView mView;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    List<Appointment> mAppointments;
    private DatabaseReference mDatabase;


    @Inject
    public AppointmentsListPresenter() {
        mDatabase = FirebaseDatabase.getInstance().getReference();

    }


    public List<Appointment> getAppointments() {
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

    public void requestData() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                GenericTypeIndicator<ArrayList<Appointment>> t = new GenericTypeIndicator<ArrayList<Appointment>>() {
                };
                ArrayList<Appointment> appointments = dataSnapshot.child("LISTACITAS").getValue(t);
                mView.showAppointments(appointments);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }


}
