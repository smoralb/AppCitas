package com.example.sergiomoral.appcitas.presentation.utils.constants;

import android.app.Application;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 27/2/18.
 */

public class BuildData {

    private Application mApplication;

    public static final long RIPPLE_DURATION = 250;
    public static final String TAG_FRAGMENT_PERSONAL_DATA = "PERSONAL DATA";
    public static final String TAG_FRAGMENT_USER_DATA = "USER DATA";
    public static final int USER = 1;
    public static final int PASSWORD = 2;
    public static  final int NAV_FORWARD = 3;
    public static final int NAV_BACKWARDS = 4;

    @Inject
    public BuildData(Application application) {
        mApplication = application;
    }

}
