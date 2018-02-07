package com.example.sergiomoral.appcitas.presentation.di.modules;

import android.app.Activity;
import android.content.Context;

import com.example.sergiomoral.appcitas.data.manager.AuthManager;
import com.example.sergiomoral.appcitas.data.manager.imp.AuthManagerImp;
import com.example.sergiomoral.appcitas.presentation.di.quialifiers.ActivityContext;
import com.example.sergiomoral.appcitas.presentation.di.quialifiers.PerActivity;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManagerImp;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sergiomoral on 31/12/17.
 */

@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    public Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    Activity providesActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    public DialogManager providesDialogManager(DialogManagerImp dialogManagerImp) { return dialogManagerImp; }

    @Provides
    public AuthManager providesAuthenticationManager (AuthManagerImp authManagerImp) { return authManagerImp; }

}
