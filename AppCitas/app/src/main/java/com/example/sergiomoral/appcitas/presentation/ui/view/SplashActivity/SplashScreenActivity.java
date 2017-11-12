package com.example.sergiomoral.appcitas.presentation.ui.view.SplashActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sergiomoral.appcitas.MainActivity;
import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;




/**
 * Created by sergiomoral on 12/11/17.
 */

public class SplashScreenActivity extends AppCompatActivity{

    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        getSupportActionBar().hide();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SplashScreenActivity.this, LoginActivity.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
