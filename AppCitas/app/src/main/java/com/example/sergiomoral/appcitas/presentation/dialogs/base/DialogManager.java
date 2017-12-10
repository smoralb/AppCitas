package com.example.sergiomoral.appcitas.presentation.dialogs.base;

/**
 * Created by sergiomoral on 10/12/17.
 */

public interface DialogManager {

    void showLoading();

    void hideLoading();

    interface DialogListener {

        void onDialogPositiveClick(BaseDialog dialog);

        void onDialogNegativeClick(BaseDialog dialog);
    }
}
