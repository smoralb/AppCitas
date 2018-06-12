package com.example.sergiomoral.appcitas.presentation.ui.view.ProfileUserActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.ProfileData;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManagerImp;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.userProfile.ProfileUserPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 11/6/18.
 */

public class ProfileUserActivity extends BaseActivity implements ProfileUserView {


    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_surname)
    EditText userSurname;
    @BindView(R.id.user_surname2)
    EditText userSurname2;
    @BindView(R.id.user_email)
    EditText userEmail;
    @BindView(R.id.btn_edit_personal_data)
    Button btnEditData;

    @Inject
    ProfileUserPresenter mPresenter;

    @Inject
    DialogManagerImp mDialogManager;
    private boolean settings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getExtras() != null) {
            settings = getIntent().getExtras().getBoolean("settings");
        }
        if (!settings) {
            userName.setFocusable(false);
            userEmail.setFocusable(false);
            userSurname.setFocusable(false);
            userSurname2.setFocusable(false);
        } else btnEditData.setVisibility(View.VISIBLE);
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
        mPresenter.attachView(this);
        mPresenter.requestUserData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_profile_user;
    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }

    @Override
    public void showUserData(ProfileData profile) {
        hideLoading();
        if (profile != null) {
            userName.setText(profile.getName());
            userSurname.setText(profile.getApellido1());
            userSurname2.setText(profile.getApellido2());
            userEmail.setText(profile.getEmail());
        } else
            mDialogManager.showError(R.drawable.ic_error, R.string.generic_title_error, R.string.error_user, this);
    }

    @OnClick(R.id.iv_back)
    public void onBack() {
        finish();
    }


    @OnClick(R.id.btn_edit_personal_data)
    public void setBtnEditData() {
        mPresenter.updateData(userName.getText().toString(), userSurname.getText().toString(), userSurname2.getText().toString(), userEmail.getText().toString(), this);
    }
}
