package com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.sections;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.SignUp.UserDataPresenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 16/3/18.
 */

public class UserDataFragment extends BaseFragment implements UserDataView {

    @BindView(R.id.tv_footer_right)
    TextView mFooterRight;

    @BindView(R.id.et_user_email)
    EditText mUserEmail;

    @BindView(R.id.et_user_password)
    EditText mUserPassword;

    @BindView(R.id.et_user_repeat_password)
    EditText mUserRepeatPassword;

    @Inject
    UserDataPresenter mPresenter;

    private Listener mListener;

    public UserDataFragment() {
    }

    public static UserDataFragment newInstance() {
        return new UserDataFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user_data;
    }

    @Override
    public void initializeInjector() {
        DaggerActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    public void initUi() {
        mFooterRight.setText(getString(R.string.finalize));
    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (Listener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @OnClick(R.id.tv_footer_right)
    public void finalizeSignUp() {
        String userEmail = mUserEmail.getText().toString();
        String userPassword = mUserPassword.getText().toString();
        String userRepeatPassword = mUserRepeatPassword.getText().toString();
        mListener.confirmAppointment(userEmail, userPassword, userRepeatPassword);
    }

    public void showFormError() {
        showError(R.string.error_values);
    }

    @OnClick(R.id.tv_footer_left)
    public void returnToBackStack() {
        mListener.returnToPersonalDataStep();
    }

    public interface Listener {

        void confirmAppointment(String email, String password, String repeatPassword);

        void returnToPersonalDataStep();
    }
}
