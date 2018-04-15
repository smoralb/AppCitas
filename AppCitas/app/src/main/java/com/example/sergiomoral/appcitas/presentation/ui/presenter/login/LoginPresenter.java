package com.example.sergiomoral.appcitas.presentation.ui.presenter.login;

import android.text.TextUtils;

import com.example.sergiomoral.appcitas.data.manager.signin.AuthManager;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginView;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 30/1/18.
 */

public class LoginPresenter implements Presenter<LoginView> {

    private LoginView mView;

    private AuthManager mAuthManager;


    String regexpEmail = "^[A-Za-z][A-Za-z0-9_.-]*@[A-Za-z0-9_.-]+\\.[A-Za-z0-9_.]+[A-za-z]$";
    String regexpPassword = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,15}$/";

    @Inject
    public LoginPresenter(AuthManager authManager) {
        this.mAuthManager = authManager;
    }

    @Override
    public void attachView(LoginView view) {
        mView = view;
    }

    public void initLoginProcess(final String user, final String password) {
        if (!isEmpty(user, password)) {
            if (isEmailValid(user) /*|| isPasswordValid(password)*/) {
                showLoading();
                mAuthManager.signInUser(user, password);
                mView.goToListAppointments(mAuthManager.getCurrentUserId());
            }
            mView.hideLoading();
        } else
            mView.showEmptyFieldsError();
    }


    public boolean isEmpty(String user, String password) {
        return TextUtils.isEmpty(user) || TextUtils.isEmpty(password);
    }

    public boolean isEmailValid(String user) {
        return user.matches(regexpEmail);
    }

    public boolean isPasswordValid(String password) {
        return password.matches(regexpPassword);
    }

    private void showLoading() {
        if (mView != null) {
            mView.showLoading();
        }
    }


}
