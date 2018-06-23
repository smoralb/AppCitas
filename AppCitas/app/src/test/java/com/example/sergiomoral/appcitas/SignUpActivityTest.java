package com.example.sergiomoral.appcitas;

import android.app.Activity;

import com.example.sergiomoral.appcitas.presentation.ui.view.CreateAppointmentActivity.CreateAppointmentActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpActivity;
import com.google.firebase.FirebaseApp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by sergiomoral on 23/6/18.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class SignUpActivityTest {


    private Activity activity;

    @Before
    public void setUp() throws Exception {

        activity = Robolectric.buildActivity(SignUpActivity.class)
                .create()
                .resume()
                .get();

        FirebaseApp.initializeApp(activity);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }
}
