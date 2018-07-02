package com.example.sergiomoral.appcitas;

import android.app.Activity;

import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.presentation.ui.view.DetailsActivity.AppointmentDetailsActivity;
import com.google.firebase.FirebaseApp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sergiomoral on 23/6/18.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class AppointmentDetailsActivityTest {


    private Activity activity;

    @Before
    public void setUp() throws Exception {

        activity = Robolectric.buildActivity(AppointmentDetailsActivity.class)
                .create()
                .resume()
                .get();

        FirebaseApp.initializeApp(activity);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);

        Appointment appointment = mock(Appointment.class);

        when(appointment.getFechacita() == null).thenThrow(new NullPointerException());
        when(appointment.getHoracita() == null).thenThrow(new NullPointerException());
        when(appointment.getOficina() == null).thenThrow(new NullPointerException());

    }

    @Test
    public void continueToModify(){

    }
}
