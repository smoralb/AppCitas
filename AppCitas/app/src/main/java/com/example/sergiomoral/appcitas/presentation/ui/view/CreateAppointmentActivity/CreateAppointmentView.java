package com.example.sergiomoral.appcitas.presentation.ui.view.CreateAppointmentActivity;

import com.example.sergiomoral.appcitas.domain.entities.Center;

import java.util.ArrayList;

/**
 * Created by sergiomoral on 9/6/18.
 */

public interface CreateAppointmentView {

    void showLoading();

    void hideLoading();

    void showServices(ArrayList<String> services);

    void showStablishments(ArrayList<Center> centers);
}
