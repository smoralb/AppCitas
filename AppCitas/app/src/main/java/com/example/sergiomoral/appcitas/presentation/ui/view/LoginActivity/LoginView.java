package com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity;

import com.example.sergiomoral.appcitas.presentation.ui.view.BaseView;

/**
 * Created by sergiomoral on 10/1/18.
 */

public interface LoginView extends BaseView{

    void showEmptyFieldsError();

    void showLoginError();

    void gotToNetworkError();

    void goToSignUpActivity();

}
