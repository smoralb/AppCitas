package com.example.sergiomoral.appcitas.presentation.ui.presenter.appointmentDetails;

import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManagerImp;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.DetailsActivity.AppointmentDetailsView;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    public void deleteAppointment(Appointment appointment) {
        DatabaseReference localReference = FirebaseDatabase.getInstance().getReference().child(BuildData.APPOINTMENTS_LIST).child(appointment.getKey());
        localReference.removeValue();
        mView.goToAppointments();
    }

}
