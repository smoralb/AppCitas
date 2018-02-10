package com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity;


import android.widget.EditText;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.SignUp.SignUpPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 18/11/17.
 */

public class SignUpActivity extends BaseActivity implements SignUpView {

    @BindView(R.id.et_user_email)
    EditText mUserEmail;

    @BindView(R.id.et_user_password)
    EditText mUserPassword;

    @Inject
    public SignUpPresenter mPresenter;

    @Inject
    public DialogManager mDialogManager;

    @Inject
    public SignUpActivity() {
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
        return R.layout.activity_signup;
    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }


    @OnClick(R.id.btn_signup)
    public void authenticateForm() {
        if (mPresenter.isValid(mUserEmail, mUserPassword)) {
            mPresenter.initSignUpProccess(mUserEmail.getText().toString(), mUserPassword.getText().toString());
        }
    }


    @Override
    public void signUpError() {
        mDialogManager.showErrorSignUp(R.drawable.ic_error, R.string.error_title, R.string.error_user);
    }

    @Override
    public void signUpSuccess() {
        mDialogManager.showSuccessSignUp(R.drawable.ic_ok, R.string.success_title, R.string.success_message);

    }

    @OnClick(R.id.lbl_login)
    @Override
    public void goToLoginActivity() {
        finish();
    }

    @Override
    public void setError(int field, int message) {
        if (field == SignUpPresenter.USER) {
            mUserEmail.setError(getString(message));
        } else mUserPassword.setError(getString(message));
    }
}
