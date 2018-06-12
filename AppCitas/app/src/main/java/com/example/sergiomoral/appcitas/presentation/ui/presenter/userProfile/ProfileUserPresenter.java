package com.example.sergiomoral.appcitas.presentation.ui.presenter.userProfile;

import android.app.Activity;
import android.util.Log;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.ProfileData;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManagerImp;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.ProfileUserActivity.ProfileUserView;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import javax.inject.Inject;

/**
 * Created by sergiomoral on 11/6/18.
 */

public class ProfileUserPresenter implements Presenter<ProfileUserView> {

    ProfileUserView mView;
    private DatabaseReference mDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;
    String userID;

    @Inject
    DialogManagerImp mDialogManager;

    @Inject
    public ProfileUserPresenter() {
        mDatabase = FirebaseDatabase.getInstance().getReference(BuildData.USERS_LIST);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        userID = user.getUid();
    }

    @Override
    public void attachView(ProfileUserView view) {
        this.mView = view;
    }

    public void requestUserData() {
        showLoading();

        mDatabase.keepSynced(true);

        mDatabase.child(userID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                showUserData(dataSnapshot);
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(BuildData.TAG_DATABASE_ERROR, "loadPost:onCancelled", error.toException());
            }
        });
    }

    private void showUserData(DataSnapshot dataSnapshot) {

        ProfileData profile = dataSnapshot.getValue(ProfileData.class);

        mView.showUserData(profile);
    }


    private void showLoading() {
        if (mView != null) {
            mView.showLoading();
        }
    }

    public void updateData(String name, String surname, String surname2, String email, Activity activity) {
        mDatabase.child(userID).child("name").setValue(name);
        mDatabase.child(userID).child("apellido1").setValue(surname);
        mDatabase.child(userID).child("apellido2").setValue(surname2);
        mDatabase.child(userID).child("email").setValue(email);
        mDialogManager.showSuccess(R.drawable.ic_ok,R.string.success_title, R.string.success_message, activity);
    }
}
