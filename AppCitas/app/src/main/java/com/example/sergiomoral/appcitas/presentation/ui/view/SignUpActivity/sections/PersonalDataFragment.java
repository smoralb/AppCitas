package com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.sections;

import android.content.Context;
import android.widget.EditText;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.signUp.PersonalDataPresenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 16/3/18.
 */

public class PersonalDataFragment extends BaseFragment implements PersonalDataView {

    @BindView(R.id.et_user_name)
    EditText mUserName;

    @BindView(R.id.et_user_surname)
    EditText mUserSurname;

    @BindView(R.id.et_user_surname2)
    EditText mUserSurname2;


    private Listener mListener;

    @Inject
    PersonalDataPresenter mPresenter;

    public PersonalDataFragment() {
    }

    public static PersonalDataFragment newInstance() {
        return new PersonalDataFragment();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_data;
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
        mPresenter.attachView(this);

    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }

    @OnClick(R.id.tv_footer_right)
    public void goToUserData() {
        mPresenter.onNextClick();
    }

    @OnClick(R.id.tv_footer_left)
    public void goToLogin() {
        mListener.returnToLogin();
    }


    @Override
    public void navigateToUserData() {
        mListener.continueRegister(mUserName.getText().toString(), mUserSurname.getText().toString(), mUserSurname2.getText().toString(),"");
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


    public interface Listener {

        void continueRegister(String name, String surname, String surname2, String userID);

        void returnToLogin();
    }
}
