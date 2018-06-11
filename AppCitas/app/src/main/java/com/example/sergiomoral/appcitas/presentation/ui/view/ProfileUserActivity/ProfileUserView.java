package com.example.sergiomoral.appcitas.presentation.ui.view.ProfileUserActivity;

import com.example.sergiomoral.appcitas.domain.entities.ProfileData;
import com.example.sergiomoral.appcitas.presentation.ui.view.BaseView;

/**
 * Created by sergiomoral on 11/6/18.
 */

public interface ProfileUserView extends BaseView{

    void showUserData(ProfileData profile);
}
