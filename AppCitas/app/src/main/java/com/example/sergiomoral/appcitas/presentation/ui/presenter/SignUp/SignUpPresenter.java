package com.example.sergiomoral.appcitas.presentation.ui.presenter.signUp;

import android.content.Context;

import com.example.sergiomoral.appcitas.data.manager.signin.AuthManager;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpView;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 6/2/18.
 */

public class SignUpPresenter implements Presenter<SignUpView> {

    private SignUpView mView;
    private AuthManager mAuth;

    private String userName, userSurname, userSurname2, userID;


    @Inject
    public SignUpPresenter(AuthManager authManager) {
        mAuth = authManager;
    }

    public void initSignUpProccess(String userEmail, String password, Context context) {

        mAuth.signUpUser(userName, userSurname, userSurname2, userID, userEmail, password,context);
    }

    @Override
    public void attachView(SignUpView view) {
        mView = view;
    }


    public void returnToPersonalData() {
        mView.showOrHidePersonalData(BuildData.NAV_BACKWARDS);
    }


    public void goToUserDataStep(String userName, String userSurname, String userSurname2, String userID) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userSurname2 = userSurname2;
        this.userID = userID;
        mView.showOrHideUserData(BuildData.NAV_FORWARD);
    }

    public void initialize() {
        mView.showOrHidePersonalData(BuildData.NAV_FORWARD);
    }
}
