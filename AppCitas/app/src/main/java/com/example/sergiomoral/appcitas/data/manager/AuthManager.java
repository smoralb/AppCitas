package com.example.sergiomoral.appcitas.data.manager;


/**
 * Created by sergiomoral on 30/1/18.
 */

public interface AuthManager {

    void signInUser(String email, String password);

    boolean signUpUser(String email, String password);

    boolean isSignedIn();

    void signOut();

    String getCurrentUserId();
}
