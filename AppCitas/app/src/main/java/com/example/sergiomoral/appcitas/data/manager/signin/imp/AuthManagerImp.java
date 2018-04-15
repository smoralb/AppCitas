package com.example.sergiomoral.appcitas.data.manager.signin.imp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.data.manager.BaseManager;
import com.example.sergiomoral.appcitas.data.manager.signin.AuthManager;
import com.example.sergiomoral.appcitas.domain.entities.User;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;
import com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity.SignUpActivity;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


/**
 * Created by sergiomoral on 30/1/18.
 */

public class AuthManagerImp extends BaseManager implements AuthManager {

    private FirebaseAuth mAuth;
    private DatabaseReference mDataBase;

    User mUser;

    @Inject
    DialogManager mDialogManager;


    @Inject
    public AuthManagerImp() {
        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference();
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
    public void signInUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password);
    }

    @Override
    public void signUpUser(String userName, String userSurname, String userSurname2, String userID, String email, String password, final Context context) {

        final Activity activity = (Activity) context;

        this.mUser = new User.Builder()
                .name(userName)
                .apellido1(userSurname)
                .apellido2(userSurname2)
                .userId(userID)
                .email(email)
                .password(password)
                .build();


        mAuth.createUserWithEmailAndPassword(mUser.getEmail(), mUser.getPassword())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            mDialogManager.showSuccessSignUp(R.drawable.ic_ok, R.string.success_title, R.string.success_message,activity);
                            FirebaseUser user = mAuth.getCurrentUser();
                            mDataBase.child("USERSLIST").child(user.getUid()).setValue(mUser);
                            Log.d("AuthManagerImp", "signUpWithEmail:success");
                        } else {
                            mDialogManager.showErrorSignUp(R.drawable.ic_error, R.string.generic_error, R.string.error_user,activity);
                            Log.w("AuthManagerImp", "signUpWithEmail:failure", task.getException());
                        }
                    }
                });
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
