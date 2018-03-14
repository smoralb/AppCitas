package com.example.sergiomoral.appcitas.presentation.utils.constants;

import android.app.Application;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 27/2/18.
 */

public class BuildData {

    private Application mApplication;

    public static final String ENDPOINT = "https://appointments-tfg.firebaseio.com";

    @Inject
    public BuildData(Application application) {
        mApplication = application;
    }

}
