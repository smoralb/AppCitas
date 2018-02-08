package com.example.sergiomoral.appcitas.presentation.ui.presenter.SignUp;

import android.text.TextUtils;
import android.widget.EditText;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.data.manager.AuthManager;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpView;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 6/2/18.
 */

public class SignUpPresenter implements Presenter<SignUpView> {

    private SignUpView mView;

    private AuthManager mAuth;

    String regexpEmail = "^[A-Za-z][A-Za-z0-9_.-]*@[A-Za-z0-9_.-]+\\.[A-Za-z0-9_.]+[A-za-z]$";
    String regexpPassword = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,15}$/";

    public static final int USER = 1;
    public static final int PASSWORD = 2;

    @Inject
    public SignUpPresenter(AuthManager authManager) {
        mAuth = authManager;
    }

    public void initSignUpProccess(String user, String password) {
        mAuth.signUpUser(user, password);
    }

    @Override
    public void attachView(SignUpView view) {
        mView = view;
    }

    public boolean isValid(EditText user, EditText password) {

        boolean valid = false;
        if (TextUtils.isEmpty(user.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
            mView.setError(USER, R.string.error_empty_field);
        } else if (!user.getText().toString().matches(regexpEmail)) {
            mView.setError(USER, R.string.error_email);
        } /*else if (!password.getText().toString().matches(regexpPassword)) {
            mView.setError(PASSWORD, R.string.error_password);
        } */else {
            valid = true;
        }
        return valid;
    }
}
