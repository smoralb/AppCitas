package com.example.sergiomoral.appcitas.data.manager;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by sergiomoral on 30/1/18.
 */

public interface AuthManager {

    void signInEmail (@NonNull FirebaseAuth firebaseAuth);

}
