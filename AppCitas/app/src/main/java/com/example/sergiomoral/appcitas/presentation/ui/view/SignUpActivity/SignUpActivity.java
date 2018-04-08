package com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.User;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.SignUp.SignUpPresenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.sections.PersonalDataFragment;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.sections.UserDataFragment;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * Created by sergiomoral on 18/11/17.
 */

public class SignUpActivity extends BaseActivity implements SignUpView, PersonalDataFragment.Listener, UserDataFragment.Listener {


    @BindView(R.id.tv_action_title)
    TextView actionTitleTextView;

    @Inject
    public SignUpPresenter mPresenter;

    @Inject
    public DialogManager mDialogManager;

    private int currentStep = 1;
    private User mUser = new User();
    private PersonalDataFragment mPersonalDataFragment;
    private UserDataFragment mUserDataFragment;


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
        initializePresenter();
        initLabels();
        mPersonalDataFragment = new PersonalDataFragment();
        mUserDataFragment = new UserDataFragment();
    }

    private void initializePresenter() {
        mPresenter.initialize();
    }

    public void initLabels() {
        showStep(currentStep);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_signup;
    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }


    @Override
    public void signUpError() {
        mDialogManager.showErrorSignUp(R.drawable.ic_error, R.string.generic_error, R.string.error_user);
    }

    @Override
    public void signUpSuccess() {
        mDialogManager.showSuccessSignUp(R.drawable.ic_ok, R.string.success_title, R.string.success_message);

    }

    @Override
    public void setError(int field, int message) {
       /* if (field == SignUpPresenter.USER) {
            mUserEmail.setError(getString(message));
        } else mUserPassword.setError(getString(message));
        */
    }

    @Override
    public void confirmAppointment(String email, String password, String repeatPassword) {
        if (isValid(email, password, repeatPassword)) {
            mUser.setEmail(email);
            if (password.equals(repeatPassword)) {
                mUser.setPassword(password);
                mPresenter.initSignUpProccess(email, password);
            }
        } else {
            mDialogManager.showErrorSignUp(R.drawable.ic_error, R.string.generic_error, R.string.error_passwords);
        }
    }

    @Override
    public void returnToPersonalDataStep() {
        onBackPressed();
    }

    public boolean isValid(String email, String password, String repeatPassword) {
        return !(email.equals("") && password.equals("") && repeatPassword.equals(""));
    }


    @Override
    public void continueRegister(String name, String surname, String surname2, String userID) {
        if (isValid(name, surname, surname2, userID)) {
            mPresenter.goToUserDataStep(name, surname, surname2, userID);
        } else {
            mDialogManager.showErrorSignUp(R.drawable.ic_error, R.string.generic_error, R.string.error_values);
        }
    }

    @Override
    public void returnToLogin() {
        finish();
    }


    private void showStep(int step) {
        currentStep = step;
        if (actionTitleTextView != null) {
            switch (step) {
                case 1:
                    actionTitleTextView.setText(R.string.personal_data);
                    break;
                case 2:
                    actionTitleTextView.setText(R.string.user_data);
                    break;
            }
        }
    }


    @Override
    public void showOrHidePersonalData(int navMode) {
        showStep(1);
        FragmentManager fm = getSupportFragmentManager();
        if (navMode == BuildData.NAV_FORWARD) {
            Bundle args = new Bundle();
            PersonalDataFragment dataFragment = PersonalDataFragment.newInstance();
            dataFragment.setArguments(args);
            fm.beginTransaction()
                    .setCustomAnimations(R.anim.anim_enter_right, R.anim.anim_leave_right)
                    .add(R.id.v_container, dataFragment, BuildData.TAG_FRAGMENT_PERSONAL_DATA)
                    .commit();
        } else {
            fm.beginTransaction()
                    .setCustomAnimations(R.anim.anim_enter_left, R.anim.anim_leave_left)
                    .remove(getSupportFragmentManager().findFragmentByTag(BuildData.TAG_FRAGMENT_PERSONAL_DATA))
                    .commit();
        }
    }

    @Override
    public void showOrHideUserData(int navMode) {
        FragmentManager fm = getSupportFragmentManager();
        if (navMode == BuildData.NAV_FORWARD) {
            showStep(2);
            Bundle args = new Bundle();
            UserDataFragment userDataFragment = UserDataFragment.newInstance();
            userDataFragment.setArguments(args);
            fm.beginTransaction()
                    .setCustomAnimations(R.anim.anim_enter_right, R.anim.anim_leave_right)
                    .replace(R.id.v_container, userDataFragment)
                    .addToBackStack(null)
                    //.add(R.id.v_continer, userDataFragment, BuildData.TAG_FRAGMENT_USER_DATA)
                    .commit();

        } else {
            showStep(1);
            fm.beginTransaction()
                    .setCustomAnimations(R.anim.anim_enter_left, R.anim.anim_leave_left)
                    .remove(getSupportFragmentManager().findFragmentByTag(BuildData.TAG_FRAGMENT_PERSONAL_DATA))
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public boolean isValid(String name, String surname, String surname2, String userID) {
        if (!name.equals("") && !surname.equals("")
                && !surname2.equals("") && !userID.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}

