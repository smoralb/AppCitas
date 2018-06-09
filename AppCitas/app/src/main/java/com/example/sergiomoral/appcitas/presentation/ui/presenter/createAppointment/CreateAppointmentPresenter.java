package com.example.sergiomoral.appcitas.presentation.ui.presenter.createAppointment;

import android.app.Activity;
import android.util.Log;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Center;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManagerImp;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.CreateAppointmentActivity.CreateAppointmentView;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 9/6/18.
 */

public class CreateAppointmentPresenter implements Presenter<CreateAppointmentView> {

    private CreateAppointmentView mView;
    private DatabaseReference mDatabaseRef;

    @Inject
    public DialogManagerImp mDialogManager;
    private Activity activity;


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

                GenericTypeIndicator<ArrayList<Center>> typeIndicator = new GenericTypeIndicator<ArrayList<Center>>() {
                };
                ArrayList<Center> centers = dataSnapshot.child(BuildData.CENTERS_LIST).getValue(typeIndicator);
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
}
