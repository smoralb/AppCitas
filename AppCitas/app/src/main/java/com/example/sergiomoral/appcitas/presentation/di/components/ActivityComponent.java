package com.example.sergiomoral.appcitas.presentation.di.components;

import com.example.sergiomoral.appcitas.presentation.ui.main.MainActivity;
import com.example.sergiomoral.appcitas.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.appcitas.presentation.di.quialifiers.PerActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpActivity;

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

}
