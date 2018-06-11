package com.example.sergiomoral.appcitas.presentation.ui.view.ProfileUserActivity;

import android.widget.TextView;

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
    TextView userName;
    @BindView(R.id.user_surname)
    TextView userSurname;
    @BindView(R.id.user_surname2)
    TextView userSurname2;
    @BindView(R.id.user_email)
    TextView userEmail;

    @Inject
    ProfileUserPresenter mPresenter;

    @Inject
    DialogManagerImp mDialogManager;


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
}
