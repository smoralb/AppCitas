package com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;
import com.example.sergiomoral.appcitas.presentation.ui.main.MainActivity;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.login.LoginPresenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.NetworkErrorActivity.NetworkErrorActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpActivity;

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

    @Inject
    DialogManager mDialogManager;

    @Inject
    LoginPresenter mLoginPresenter;

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
        mUserEmail.getText().clear();
        mUserPassword.getText().clear();
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
        startActivity(goToRegister);
    }

    @Override
    public void goToListAppointments() {
        Intent goToAppointments = new Intent(this, MainActivity.class);
        startActivity(goToAppointments);
    }

    @OnClick(R.id.btn_login)
    public void loginProcess() {
        mLoginPresenter.initLoginProcess(mUserEmail.getText().toString(), mUserPassword.getText().toString());
    }


}
