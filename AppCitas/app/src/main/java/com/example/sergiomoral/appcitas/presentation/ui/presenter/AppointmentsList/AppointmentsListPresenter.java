package com.example.sergiomoral.appcitas.presentation.ui.presenter.AppointmentsList;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.AppointmentsListView;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;
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

    private AppointmentsListView mView;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    ArrayList<Appointment> mAppointments = new ArrayList<>();
    ArrayList<Appointment> mAppointmentsFilteredByUser = new ArrayList<>();
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

    public void requestData(final String userToken) {
        mView.showLoading();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<Appointment>> t = new GenericTypeIndicator<ArrayList<Appointment>>() {
                };
                ArrayList<Appointment> appointments = dataSnapshot.child("LISTACITAS").getValue(t);
                int index = 0;
                for (Appointment appointment : appointments) {
                    if (appointments.get(index).getUserID().equals(userToken)) {
                        mAppointmentsFilteredByUser.add(appointment);
                        index++;
                    } else {
                        index++;
                    }
                }
                mView.showAppointments(mAppointmentsFilteredByUser);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(BuildData.TAG_DATABASE_ERROR, "loadPost:onCancelled", error.toException());
            }
        });
    }


    public void initGuillotineAnimation(View guillotineMenu, Toolbar toolbar, View contentHamburger) {
        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(BuildData.RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }
}
