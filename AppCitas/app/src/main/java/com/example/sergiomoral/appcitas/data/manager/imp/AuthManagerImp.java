package com.example.sergiomoral.appcitas.data.manager.imp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.sergiomoral.appcitas.data.manager.AuthManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 30/1/18.
 */

public class AuthManagerImp extends Activity implements AuthManager {


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Inject
    public AuthManagerImp(){

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                signInEmail(firebaseAuth);
            }
        };
        createAccount();
        signInAccount();
    }

    private void createAccount() {
        mAuth.createUserWithEmailAndPassword("example@email.com", "password")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("Main Activity", "createUserWithEmail:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Toast.makeText(AuthManagerImp.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signInAccount() {
        mAuth.signInWithEmailAndPassword("example@email.com", "password")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("Main Activity", "signInWithEmail:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Toast.makeText(AuthManagerImp.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    @Override
    public void signInEmail(@NonNull FirebaseAuth firebaseAuth) {
        // Comprueba si el usuario ya ha accedido
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            // User is signed in
            Log.d("Main Activity", "onAuthStateChanged:signed_in:" + user.getUid());
        } else {
            // User is signed out
            Log.d("Main Activity", "onAuthStateChanged:signed_out");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
