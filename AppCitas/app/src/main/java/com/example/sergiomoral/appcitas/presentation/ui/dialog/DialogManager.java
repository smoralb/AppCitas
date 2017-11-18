package com.example.sergiomoral.appcitas.presentation.ui.dialog;

/**
 * Created by sergiomoral on 18/11/17.
 */

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;

public interface DialogManager {

    void showInfoDialog(@DrawableRes int iconId, String title, String content, DialogListener dialogListener);

    void showInfoDialog(@DrawableRes int iconId, String title, String content, @StringRes int neutralTextId,
                        DialogListener dialogListener, NeutralDialogListener neutralDialogListener);

    void showInfoDialog(@DrawableRes int iconId, String title, String content, @StringRes int positiveTextId,
                        @StringRes int negativeTextId, DialogListener dialogListener);

    void showCreateAppointmentDialog(String email, String phone, CreateAppointmentListener createAppointmentListener);

    void showLoading();

    void hideLoading();

    interface AccessDialogListener {

        void onLoginClick();

        void onSignUpClick();
    }

    interface CreateAppointmentListener {
        void onCreateClick(String email, String phone);
    }

    interface DialogListener {
        void onDialogPositiveClick(DialogFragment dialog);

        void onDialogNegativeClick(DialogFragment dialog);
    }

    interface NeutralDialogListener {

        void onDialogNeutralClick(DialogFragment dialog);
    }
}

