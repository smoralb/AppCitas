package com.example.sergiomoral.appcitas.presentation.ui.presenter.createAppointment;

import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManagerImp;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.CreateAppointmentActivity.CreateAppointmentView;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 9/6/18.
 */

public class CreateAppointmentPresenter implements Presenter<CreateAppointmentView>{

    private CreateAppointmentView mView;

    @Inject
    private DialogManagerImp mDialogManager;

    @Inject
    public CreateAppointmentPresenter() {
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
}
