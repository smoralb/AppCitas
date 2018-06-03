package com.example.sergiomoral.appcitas.presentation.ui.presenter.signUp;

import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.sections.UserDataView;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 16/3/18.
 */

public class UserDataPresenter implements Presenter<UserDataView> {

    private UserDataView mView;

    @Inject
    public UserDataPresenter() {
    }

/*
    public boolean isValid(EditText user, EditText password) {

        boolean valid = false;
        if (TextUtils.isEmpty(user.getText().toString())) {
            mView.setError(BuildData.USER, R.string.error_empty_field);
        } else if (TextUtils.isEmpty(password.getText().toString())) {
            mView.setError(BuildData.PASSWORD, R.string.error_empty_field);
        } else if (!user.getText().toString().matches(regexpEmail)) {
            mView.setError(BuildData.USER, R.string.error_email);
        } else if (!password.getText().toString().matches(regexpPassword)) {
            mView.setError(PASSWORD, R.string.error_password);
        }  else {
            valid = true;
        }
        return valid;
    }

        return true;
    }
     */

    @Override
    public void attachView(UserDataView view) {
        mView = view;
    }
}
