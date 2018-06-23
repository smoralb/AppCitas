package com.example.sergiomoral.appcitas;

import android.app.Activity;
import android.content.Intent;

import com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.AppointmentsListActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpActivity;
import com.google.firebase.FirebaseApp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by sergiomoral on 23/6/18.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class LoginActivityTest {

    private Activity activity;

    @Before
    public void setUp() throws Exception {

        activity = Robolectric.buildActivity(LoginActivity.class)
                .create()
                .resume()
                .get();

        FirebaseApp.initializeApp(activity);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void continueToAppointmentListActivity() {
        // define the expected results
        Intent expectedIntent = new Intent(activity, AppointmentsListActivity.class);

        // click the continue button
        activity.findViewById(R.id.btn_login).callOnClick();

        // get the actual results
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();

        // check if the expected results match the actual results
        assertTrue(expectedIntent.filterEquals(actualIntent));
    }

    @Test
    public void continueToRegister() {
        // define the expected results
        Intent expectedIntent = new Intent(activity, SignUpActivity.class);

        // click the continue button
        activity.findViewById(R.id.tv_signUp).callOnClick();

        // get the actual results
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();

        // check if the expected results match the actual results
        assertTrue(expectedIntent.filterEquals(actualIntent));
    }

}
