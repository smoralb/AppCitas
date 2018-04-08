package com.example.sergiomoral.appcitas.data.manager.signup;

/**
 * Created by sergiomoral on 14/3/18.
 */

public interface SignUpManager {

    boolean isRegistered(String userEmail, String userID);

    void registerUser(String nombre, String apellido1, String apellido2, String email, String numberID, String mobilePhone);
}
