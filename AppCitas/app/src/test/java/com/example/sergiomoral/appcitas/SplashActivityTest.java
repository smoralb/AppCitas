package com.example.sergiomoral.appcitas;

import android.app.Activity;
import android.content.Intent;

import com.example.sergiomoral.appcitas.presentation.ui.view.CreateAppointmentActivity.CreateAppointmentActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.SplashActivity.SplashScreenActivity;
import com.google.firebase.FirebaseApp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by sergiomoral on 23/6/18.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class SplashActivityTest {


    private Activity activity;

    @Before
    public void setUp() throws Exception {

        activity = Robolectric.buildActivity(SplashScreenActivity.class)
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
    public void test() {
        ActivityController<SplashScreenActivity> controller = Robolectric.buildActivity(SplashScreenActivity.class).create().start();
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();

        SplashScreenActivity splashScreenActivity = controller.get();
        Intent expectedIntent = new Intent(splashScreenActivity, LoginActivity.class);

        assertTrue(expectedIntent.filterEquals(expectedIntent));
    }
}
