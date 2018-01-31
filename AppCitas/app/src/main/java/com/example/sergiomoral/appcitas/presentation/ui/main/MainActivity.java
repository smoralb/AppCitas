package com.example.sergiomoral.appcitas.presentation.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.sergiomoral.appcitas.presentation.di.components.ApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.ApplicationModule;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends Activity {


    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjector();

    }

    private void initInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(getApplication()))
                .build();
    }

}
