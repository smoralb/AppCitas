package com.example.sergiomoral.appcitas.data.manager.signin;


import android.app.Activity;
import android.content.Context;

/**
 * Created by sergiomoral on 30/1/18.
 */

public interface AuthManager {

    void signInUser(String email, String password);

    void signUpUser(String userName, String userSurname, String userSurname2, String userID, String email, String password, Context context);

    boolean isSignedIn();

    void signOut();

    String getCurrentUserId();
}
