package com.example.sergiomoral.appcitas.presentation.ui.presenter.SignUp;

import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.sections.PersonalDataView;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 16/3/18.
 */

public class PersonalDataPresenter implements Presenter<PersonalDataView>{


    private PersonalDataView mView;

    @Inject
    public PersonalDataPresenter() {

    }

    @Override
    public void attachView(PersonalDataView view) {
        mView = view;
    }


    public void onNextClick() {
        mView.navigateToUserData();
    }

}
