package com.example.sergiomoral.appcitas.data.manager.signin;


/**
 * Created by sergiomoral on 30/1/18.
 */

public interface AuthManager {

    void signInUser(String email, String password);

    boolean signUpUser(String userName,String userSurname, String userSurname2, String userID,String email, String password);

    boolean isSignedIn();

    void signOut();

    String getCurrentUserId();
}
