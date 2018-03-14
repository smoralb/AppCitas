package com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity;

import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.presentation.ui.view.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergiomoral on 8/2/18.
 */

public interface AppointmentsListView extends BaseView {

    void goToLogin();

    void showAppointments(ArrayList<Appointment> appointments);

}
