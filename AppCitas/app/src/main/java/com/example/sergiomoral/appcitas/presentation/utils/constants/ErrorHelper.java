package com.example.sergiomoral.appcitas.presentation.utils.constants;

import android.app.Application;

import com.example.sergiomoral.appcitas.R;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 26/2/18.
 */

public class ErrorHelper {

    // We need the application context for handle the exception in all the lifecycle of the application
    private Application mApplication;

    public static final int NO_CONNECTION = 1000;

    @Inject
    public ErrorHelper(Application application) {
        mApplication = application;
    }


    public String fromCode(int code) {
        switch (code) {
            case NO_CONNECTION:
                return mApplication.getString(R.string.error_connection);
            default:
                return mApplication.getString(R.string.generic_error);
        }
    }
}
