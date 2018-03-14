package com.example.sergiomoral.appcitas.presentation.utils.constants;

import android.app.Application;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 5/3/18.
 */

public class MapperConstants {

    private Application mApplication;

    public static final String LISTACITAS = "LISTACITAS";
    public static final String TAG = "MAPPER";
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    @Inject
    public MapperConstants(Application application) {
        mApplication = application;
    }

}
