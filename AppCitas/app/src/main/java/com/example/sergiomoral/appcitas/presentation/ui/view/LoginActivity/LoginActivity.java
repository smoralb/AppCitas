package com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.login.LoginPresenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.AppointmentsListActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.NetworkErrorActivity.NetworkErrorActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpActivity;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 12/11/17.
 */

public class LoginActivity extends BaseActivity implements LoginView {


    @BindView(R.id.et_user_email)
    EditText mUserEmail;
    @BindView(R.id.et_user_password)
    EditText mUserPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.cb_remenber_me)
    CheckBox mRememberMe;

    @Inject
    DialogManager mDialogManager;
    @Inject
    LoginPresenter mLoginPresenter;

    private SharedPreferences loginPreferences;

    private boolean rememberMe = false;
    String regexpEmail = "^[A-Za-z][A-Za-z0-9_.-]*@[A-Za-z0-9_.-]+\\.[A-Za-z0-9_.]+[A-za-z]$";


    @Inject
    public LoginActivity() {

    }


    @Override
    protected void initInjector() {
        DaggerActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected void initUI() {
        initLabels();
    }

    public void initLabels() {
        loginPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        if (!loginPreferences.getString(BuildData.USER_EMAIL, "").isEmpty() && !loginPreferences.getString(BuildData.USER_PASSWORD, "").isEmpty()) {
            mUserEmail.setText(loginPreferences.getString(BuildData.USER_EMAIL, ""));
            mUserPassword.setText(loginPreferences.getString(BuildData.USER_PASSWORD, ""));
            rememberMe = loginPreferences.getBoolean(BuildData.USER_REMEMBER, false);
        }
        mRememberMe.setChecked(rememberMe);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void attachViewToPresenter() {
        mLoginPresenter.attachView(this);
    }


    @Override
    public void showEmptyFieldsError() {
        mDialogManager.showEmptyFieldsError(R.string.error_empty_field);
    }

    @Override
    public void showLoginError() {
        mDialogManager.showLoginError(R.string.error_login);
    }

    @Override
    public void gotToNetworkError() {
        Intent networkErrorIntent = new Intent(this, NetworkErrorActivity.class);
        startActivity(networkErrorIntent);
    }

    @OnClick(R.id.tv_signUp)
    public void goToSignUpActivity() {
        Intent goToRegister = new Intent(this, SignUpActivity.class);
        startActivityForResult(goToRegister, BuildData.SIGN_UP_REQUEST);
    }

    @Override
    public void goToListAppointments(String token) {
        Intent goToAppointments = new Intent(this, AppointmentsListActivity.class);
        goToAppointments.putExtra(BuildData.USER_TOKEN, token);
        startActivity(goToAppointments);
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
        initLabels();
    }

    @OnClick(R.id.btn_login)
    public void loginProcess() {
        hideSoftKeyboard();

        if (!mUserEmail.getText().toString().isEmpty() && !mUserPassword.getText().toString().isEmpty()) {
            if (mUserEmail.getText().toString().matches(regexpEmail) && mUserPassword.getText().toString().length() > 5) {
                if (mRememberMe.isChecked()) {
                    rememberMe = true;
                }
                mLoginPresenter.initLoginProcess(mUserEmail.getText().toString(), mUserPassword.getText().toString(), this, rememberMe);
            } else
                mDialogManager.showError(R.drawable.ic_error, R.string.generic_title_error, R.string.error_login, this);
        } else
            mDialogManager.showError(R.drawable.ic_error, R.string.generic_title_error, R.string.error_empty_field, this);


    }
}
