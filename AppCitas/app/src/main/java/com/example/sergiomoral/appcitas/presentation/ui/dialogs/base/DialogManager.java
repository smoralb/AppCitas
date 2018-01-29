package com.example.sergiomoral.appcitas.presentation.ui.dialogs.base;

import android.support.annotation.StringRes;

/**
 * Created by sergiomoral on 25/1/18.
 */

public interface  DialogManager {

    // Interface where we specify the methods that will be implemented in DialogManerImp and used in the different types of dialogs

    void showEmptyFieldsError(String message);

    // Error shown when the user's credentials aren't in database
    void showLoginError (@StringRes int message);

    void showLoading();

    void hideLoading();

}
