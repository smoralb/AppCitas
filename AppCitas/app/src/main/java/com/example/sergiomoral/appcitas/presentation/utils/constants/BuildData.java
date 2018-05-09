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
    public static final String TAG_DATABASE_ERROR = "DATABASE ERROR";
    public static final String USER_TOKEN = "userToken";
    public static final String ITEM_APPOINTMENT = "itemAppointment";
    public static final String USER_NAME = "userName";
    public static final String USER_PASSWORD = "userPassword";
    public static final String USER_REMEMBER = "userRemember";
    public static final String LOCATION = "location";

    public static final int USER = 1;
    public static final int PASSWORD = 2;
    public static final int NAV_FORWARD = 3;
    public static final int NAV_BACKWARDS = 4;
    public static final int SIGN_UP_REQUEST = 5;
    public static final int RESULT_KO = 6;

    @Inject
    public BuildData(Application application) {
        mApplication = application;
    }

}
