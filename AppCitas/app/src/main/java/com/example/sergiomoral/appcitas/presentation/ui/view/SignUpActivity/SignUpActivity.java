package com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 18/11/17.
 */

public class SignUpActivity extends Activity {

    @BindView(R.id.et_user_email)
    TextInputEditText mUserEmail;
    @BindView(R.id.et_user_password)
    TextInputEditText mUserPassword;

    String regexpEmail = "^[A-Za-z][A-Za-z0-9_.-]*@[A-Za-z0-9_.-]+\\.[A-Za-z0-9_.]+[A-za-z]$";
    String regexpPassword = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,15}$/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goBackLogin();
    }

    @OnClick(R.id.btn_signup)
    public void authenticateForm() {
        if (isValid()) {
            Toast.makeText(this, "Dado de alta", Toast.LENGTH_SHORT).show();
            // Registrar  el usuario introducido en la bbdd de FireBase
            //TODO: Hacer petición en el presenter y si se devuelve el ok, se elimina el boton o se manda directamente al login
        }
    }

    public boolean isValid() {

        boolean valid = false;
        if (TextUtils.isEmpty(mUserEmail.getText()) || TextUtils.isEmpty(mUserPassword.getText())) {
            mUserEmail.setError(getString(R.string.error_empty_field));
        } else if (!mUserPassword.getText().toString().matches(regexpEmail)) {
            mUserEmail.setError(getString(R.string.error_email));
        } else if (!mUserPassword.getText().toString().matches(regexpPassword)) {
            mUserPassword.setError(getString(R.string.error_password));
        } else {
            valid = true;
        }
        return valid;
    }


    @OnClick(R.id.lbl_login)
    public void goBackLogin() {
        finish();
    }

}
