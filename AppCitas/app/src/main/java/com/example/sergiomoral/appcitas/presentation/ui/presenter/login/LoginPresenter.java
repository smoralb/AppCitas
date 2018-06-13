package com.example.sergiomoral.appcitas.presentation.ui.presenter.login;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.data.manager.signin.AuthManager;
import com.example.sergiomoral.appcitas.domain.entities.User;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManagerImp;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginActivity;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginView;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 30/1/18.
 */

public class LoginPresenter implements Presenter<LoginView> {


    @Inject
    DialogManagerImp mDialogManager;

    private LoginView mView;

    private AuthManager mAuthManager;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;

    String regexpEmail = "^[A-Za-z][A-Za-z0-9_.-]*@[A-Za-z0-9_.-]+\\.[A-Za-z0-9_.]+[A-za-z]$";
    String regexpPassword = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,15}$/";
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser userData;
    private String userName;
    private String userPassword;

    @Inject
    public LoginPresenter(AuthManager authManager) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        this.mAuthManager = authManager;
    }

    @Override
    public void attachView(LoginView view) {
        mView = view;
    }

    public void initLoginProcess(final String user, final String password, final Context context, boolean rememberMe) {
        loginPreferences = context.getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        if (rememberMe) {
            showLoading();
            loginPrefsEditor.putString(BuildData.USER_EMAIL, user);
            loginPrefsEditor.putString(BuildData.USER_PASSWORD, password);
            loginPrefsEditor.putBoolean(BuildData.USER_REMEMBER, rememberMe);
        }
        loginPrefsEditor.commit();

        Query usersQuery = mDatabase.child(BuildData.USERS_LIST);

        usersQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if (user.equals(ds.child("email").getValue(String.class)) &&
                            password.equals(ds.child("password").getValue(String.class))) {
                        userName = ds.child("email").getValue(String.class);
                        userPassword = ds.child("password").getValue(String.class);
                    }
                }
                if (userName.equals(user) && userPassword.equals(password)) {
                    mAuthManager.signInUser(user, password);
                    mView.goToListAppointments(mAuthManager.getCurrentUserId());
                } else
                    mDialogManager.showError(R.drawable.ic_error, R.string.generic_title_error, R.string.error_message_no_registered, (Activity) context);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mView.hideLoading();
    }


    public boolean isEmpty(String user, String password) {
        return TextUtils.isEmpty(user) || TextUtils.isEmpty(password);
    }

    public boolean isEmailValid(String user) {
        return user.matches(regexpEmail);
    }

    public boolean isPasswordValid(String password) {
        return password.matches(regexpPassword);
    }

    private void showLoading() {
        if (mView != null) {
            mView.showLoading();
        }
    }
}
