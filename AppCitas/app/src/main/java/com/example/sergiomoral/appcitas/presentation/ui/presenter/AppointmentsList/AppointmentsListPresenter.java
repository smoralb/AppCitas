package com.example.sergiomoral.appcitas.presentation.ui.presenter.AppointmentsList;

import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.AppointmentsListView;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 8/2/18.
 */

public class AppointmentsListPresenter implements Presenter<AppointmentsListView>{


    private AppointmentsListView mView;


    @Inject
    public AppointmentsListPresenter(){

    }

    @Override
    public void attachView(AppointmentsListView view) {
        mView = view;
    }
}
