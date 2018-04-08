package com.example.sergiomoral.appcitas.data.manager.signup.imp;

import com.example.sergiomoral.appcitas.data.manager.signup.SignUpManager;
import com.example.sergiomoral.appcitas.domain.entities.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by sergiomoral on 14/3/18.
 */

public class SignUpManagerImp implements SignUpManager {


    private DatabaseReference mDatabase;

    public SignUpManagerImp() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public boolean isRegistered(String userEmail, String userID) {
        return false;
    }

    @Override
    public void registerUser(String nombre, String apellido1, String apellido2, String email, String numberID, String mobilePhone) {


        User registerUser = new User.Builder()
                .name(nombre)
                .apellido1(apellido1)
                .apellido2(apellido2)
                .email(email)
                .userId(numberID)
                .mobilePhone(mobilePhone)
                .build();

        mDatabase.child("USERSLIST").setValue(registerUser);
    }
}
