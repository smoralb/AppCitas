package com.example.sergiomoral.appcitas.presentation.ui.presenter.appointmentDetails;


import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManagerImp;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.DetailsActivity.AppointmentDetailsView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 12/5/18.
 */

public class AppointmentDetailsPresenter implements Presenter<AppointmentDetailsView> {

    private AppointmentDetailsView mView;
    DatabaseReference mDatabase;

    @Inject
    DialogManagerImp mDialogManager;

    @Inject
    public AppointmentDetailsPresenter() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void attachView(AppointmentDetailsView view) {
        this.mView = view;
    }

    private void showLoading() {
        if (mView != null) {
            mView.showLoading();
        }
    }

    public void deleteAppointment(Appointment appointment) {
        showLoading();
       /* Query mQuery = mDatabase
                .child("LISTACITAS")
                .child(appointment.getIdcita());
*/
        DatabaseReference localReference = FirebaseDatabase.getInstance().getReference().child("LISTACITAS").child(appointment.getIdcita());
        localReference.removeValue();
        hideLoading();
        mView.goToAppointments();
/*
        mQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshotDelete : dataSnapshot.getChildren()) {
                    hideLoading();
                    dataSnapshotDelete.getRef().removeValue();
                    mView.goToAppointments();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                hideLoading();
                mView.goToAppointments();
            }
        });
        */
    }

    private void hideLoading() {
        if (mView != null) {
            mView.hideLoading();
        }
    }


}
