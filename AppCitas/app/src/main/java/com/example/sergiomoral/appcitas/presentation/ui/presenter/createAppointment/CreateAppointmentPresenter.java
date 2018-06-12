package com.example.sergiomoral.appcitas.presentation.ui.presenter.createAppointment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.data.manager.signin.imp.AuthManagerImp;
import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.domain.entities.Center;
import com.example.sergiomoral.appcitas.domain.entities.Office;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManagerImp;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.CreateAppointmentActivity.CreateAppointmentView;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 9/6/18.
 */

public class CreateAppointmentPresenter implements Presenter<CreateAppointmentView> {

    private CreateAppointmentView mView;
    private DatabaseReference mDatabaseRef;

    @Inject
    public DialogManagerImp mDialogManager;
    @Inject
    public AuthManagerImp mAuthManager;

    private Activity activity;
    private boolean localityCorrect;
    private boolean serviceCorrect;
    private boolean stablishmentCorrect;
    private boolean dateCorrect;
    private boolean hourCorrect;

    @Inject
    public CreateAppointmentPresenter() {
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void attachView(CreateAppointmentView view) {
        this.mView = view;
    }

    private void showLoading() {
        if (mView != null) {
            mView.showLoading();
        }
    }

    private void hideLoading() {
        if (mView != null) {
            mView.hideLoading();
        }
    }

    public void getServices(final Activity activity) {

        showLoading();
        this.activity = activity;

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                GenericTypeIndicator<ArrayList<String>> typeIndicator = new GenericTypeIndicator<ArrayList<String>>() {
                };
                ArrayList<String> services = dataSnapshot.child(BuildData.SERVICES).getValue(typeIndicator);
                if (services != null) {
                    mView.showServices(services);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(BuildData.TAG_DATABASE_ERROR, "loadPost:onCancelled", error.toException());
                mDialogManager.showError(R.drawable.ic_error, R.string.success_title, R.string.generic_error, activity);
            }
        });
    }

    public void getStablishments() {
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                GenericTypeIndicator<ArrayList<Office>> typeIndicator = new GenericTypeIndicator<ArrayList<Office>>() {
                };
                ArrayList<Office> centers = dataSnapshot.child(BuildData.CENTERS_LIST).getValue(typeIndicator);
                if (centers != null) {
                    mView.showStablishments(centers);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(BuildData.TAG_DATABASE_ERROR, "loadPost:onCancelled", error.toException());
                mDialogManager.showError(R.drawable.ic_error, R.string.success_title, R.string.generic_error, activity);
            }
        });
    }

    public void processFormData(String localitySelected, String serviceSelected, Office centerSelected, String dateSelected, String hourSelected) {

        if (!localitySelected.equals(activity.getString(R.string.select_locality)) && !localitySelected.equals(""))
            localityCorrect = true;
        if (!serviceSelected.equals(activity.getString(R.string.select_service)) && !serviceSelected.equals(""))
            serviceCorrect = true;
        if (centerSelected != null) stablishmentCorrect = true;
        if (!dateSelected.equals("")) dateCorrect = true;
        if (!hourSelected.equals("")) hourCorrect = true;

        mView.setImageToLocality(localityCorrect);
        mView.setImageToService(serviceCorrect);
        mView.setImageToStablishment(stablishmentCorrect);
        mView.setImageToDateSelected(dateCorrect);
        mView.setImagetoHourSelected(hourCorrect);
    }

    public void sendDataToDataBase(String localitySelected, String serviceSelected, Office centerSelected, String dateSelected, String hourSelected) {

        showLoading();

        final Appointment newAppointment = new Appointment.Builder()
                .fechacita(dateSelected)
                .horacita(hourSelected)
                .userID(mAuthManager.getCurrentUserId())
                .oficina(centerSelected)
                .key("")
                .build();

        mDatabaseRef.child(BuildData.APPOINTMENTS_LIST).push().setValue(newAppointment);

        mView.goToAppointmentList();

        hideLoading();
    }

}
