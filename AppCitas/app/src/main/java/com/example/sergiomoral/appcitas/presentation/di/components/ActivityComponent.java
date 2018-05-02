package com.example.sergiomoral.appcitas.presentation.di.components;

import com.example.sergiomoral.appcitas.presentation.ui.main.MainActivity;
import com.example.sergiomoral.appcitas.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.appcitas.presentation.di.quialifiers.PerActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.DetailsActivity.AppointmentDetailsActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.AppointmentsListActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.NetworkErrorActivity.NetworkErrorActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.sections.PersonalDataFragment;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.sections.UserDataFragment;
import com.example.sergiomoral.appcitas.presentation.ui.view.SplashActivity.SplashScreenActivity;

import dagger.Component;

/**
 * Created by sergiomoral on 31/12/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(SignUpActivity signUpActivity);

    void inject(SplashScreenActivity splashScreenActivity);

    void inject(NetworkErrorActivity networkErrorActivity);

    void inject(AppointmentsListActivity appointmentsListActivity);

    void inject(PersonalDataFragment personalDataFragment);

    void inject(UserDataFragment userDataFragment);

    void inject(AppointmentDetailsActivity appointmentDetailsActivity);

}
