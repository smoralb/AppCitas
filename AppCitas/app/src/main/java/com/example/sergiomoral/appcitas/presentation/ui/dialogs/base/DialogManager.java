package com.example.sergiomoral.appcitas.presentation.ui.dialogs.base;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;

/**
 * Created by sergiomoral on 25/1/18.
 */

public interface DialogManager {

    // Interface where we specify the methods that will be implemented in DialogManerImp and used in the different types of dialogs

    void showEmptyFieldsError(@StringRes int message);

    // Error shown when the user's credentials aren't in database
    void showLoginError(@StringRes int message);

    void showLoading();

    void hideLoading();

    void showNetworkError(@DrawableRes int icon, @StringRes int title, @StringRes int msg);

    void showSuccess(@DrawableRes int icon, @StringRes int title, @StringRes int msg, Activity activity, boolean finishActivity);

    void showError(@DrawableRes int icon, @StringRes int title, @StringRes int msg, Activity activity);

    void showAlert(int title, int message, Activity activity, View.OnClickListener listener);

    void hideAlertDialog();
}
