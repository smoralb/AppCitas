package com.example.sergiomoral.appcitas.presentation.ui.view.NetworkErrorActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sergiomoral.appcitas.R;

/**
 * Created by sergiomoral on 10/12/17.
 */

public class NetworkErrorActivity extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_network_error);
    }
}
