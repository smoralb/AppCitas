package com.example.sergiomoral.appcitas.presentation.ui.presenter.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.sergiomoral.appcitas.data.manager.signin.AuthManager;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginView;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 30/1/18.
 */

public class LoginPresenter implements Presenter<LoginView> {

    private LoginView mView;

    private AuthManager mAuthManager;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;

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

    public void initLoginProcess(final String user, final String password, Context context, boolean rememberMe) {
        loginPreferences = context.getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        if (rememberMe) {
            showLoading();
            loginPrefsEditor.putString(BuildData.USER_EMAIL, user);
            loginPrefsEditor.putString(BuildData.USER_PASSWORD, password);
        } else
            mView.showEmptyFieldsError();
        loginPrefsEditor.putBoolean(BuildData.USER_REMEMBER, rememberMe);
        if (!isEmpty(user, password)) {
            mAuthManager.signInUser(user, password);
            mView.goToListAppointments(mAuthManager.getCurrentUserId());
        }
        loginPrefsEditor.apply();
        mView.hideLoading();
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
