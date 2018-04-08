package com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity;

import com.example.sergiomoral.appcitas.presentation.ui.view.BaseView;

/**
 * Created by sergiomoral on 6/2/18.
 */

public interface SignUpView extends BaseView {

    void signUpError();

    void signUpSuccess();

    //void goToLoginActivity();

    void setError(int field, int message);

    void showOrHidePersonalData(int navMode);

    void showOrHideUserData(int navMode);

}
