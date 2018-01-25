package com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.ApplicationModule;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpActivity;


import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 12/11/17.
 */

public class LoginActivity extends BaseActivity implements LoginView{


    @BindView(R.id.et_user_email)
    EditText mUserEmail;
    @BindView(R.id.et_user_password)
    EditText mUserPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    /*@Inject
    LoginPresenter loginPresenter;*/



    @Override
    protected void initInjector() {
        DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(getApplication()))
                .build();
    }

    @Override
    protected void initUI() {
        initLabels();
    }

    public void initLabels () {
        mUserEmail.getText().clear();
        mUserPassword.getText().clear();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

   /* @Override
    public void showLoginError() {
        //mDialogManager.showLoginError();
    }

    @Override
    public void showLoginEmptyFields() {

    }

    @Override
    public void gotToNetworkError() {

    }*/

    @OnClick(R.id.tv_signUp)
    public void goToSignUpActivity() {
        Intent goToRegister = new Intent(this,SignUpActivity.class);
        startActivity(goToRegister);
    }

    @OnClick(R.id.btn_login)
    public void authenticateLoginForm() {
        Toast.makeText(this, "Hol 2", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
