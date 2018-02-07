package com.example.sergiomoral.appcitas.data.manager.imp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.sergiomoral.appcitas.data.manager.AuthManager;
import com.example.sergiomoral.appcitas.data.manager.BaseManager;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;


/**
 * Created by sergiomoral on 30/1/18.
 */

public class AuthManagerImp extends BaseManager implements AuthManager {

    private FirebaseAuth mAuth;
    boolean authentication, register = false;


    @Inject
    public AuthManagerImp() {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initAuth();
    }

    public void initAuth() {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean signInUser(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Sign in successfully, get user info
                            Log.d("AuthManagerImp", "signInWithEmail:success");
                            authentication = true;
                        } else {
                            // Sign in fails
                            Log.w("AuthManagerImp", "signInWithEmail:failure", task.getException());
                        }
                    }
                });
        return authentication;
    }

    @Override
    public boolean signUpUser(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("AuthManagerImp", "signUpWithEmail:success");
                            register = true;
                        } else {
                            Log.w("AuthManagerImp", "signUpWithEmail:failure", task.getException());
                        }
                    }
                });
        return register;
    }


    @Override
    public boolean isSignedIn() {
        return mAuth.getCurrentUser() != null;
    }

    @Override
    public void signOut() {
        if (isSignedIn()) {
            mAuth.signOut();
        }
    }

    @Override
    public String getCurrentUserId() {
        return (isSignedIn()) ? mAuth.getCurrentUser().getUid() : null;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
