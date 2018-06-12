package com.example.sergiomoral.appcitas.presentation.ui.presenter.appointmentsList;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sergiomoral.appcitas.Appointments;
import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.AppointmentsListActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.AppointmentsListView;
import com.example.sergiomoral.appcitas.presentation.ui.view.ProfileUserActivity.ProfileUserActivity;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private String keyValue;


    @Inject
    public AppointmentsListPresenter() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
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

    public void clickListenerProfile(final LinearLayout profile, final AppointmentsListActivity appointmentsListActivity) {

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileData = new Intent(appointmentsListActivity,ProfileUserActivity.class);
                appointmentsListActivity.startActivity(profileData);
            }
        });
    }


    public void clickListenerSettings(LinearLayout settings, AppointmentsListActivity appointmentsListActivity) {

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
        showLoading();

        mDatabase.child(BuildData.APPOINTMENTS_LIST).keepSynced(true);

        mDatabase.child(BuildData.APPOINTMENTS_LIST).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> app = dataSnapshot.getChildren();
                for (DataSnapshot apps : app){
                    keyValue = apps.getKey();
                    setKeyValue(keyValue);
                    Appointment app2 = apps.getValue(Appointment.class);
                    mAppointmentsFilteredByUser.add(app2);
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

    private void setKeyValue(String keyValue) {
        mDatabase.child(BuildData.APPOINTMENTS_LIST).child(keyValue).child("key").setValue(keyValue);
    }

    public void initGuillotineAnimation(View guillotineMenu, Toolbar toolbar, View contentHamburger) {
        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(BuildData.RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }
}
