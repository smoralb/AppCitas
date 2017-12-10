package com.example.sergiomoral.appcitas.presentation.ui.view.LoginActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.ui.view.NetworkErrorActivity.NetworkErrorActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 12/11/17.
 */

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.et_user_email)
    EditText mUserEmail;
    @BindView(R.id.et_user_password)
    EditText mUserPassword;

    TextInputLayout textInputLayoutUserName;
    TextInputLayout textInputLayoutUserPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

    }


    @OnClick(R.id.tv_signUp)
    public void goToRegister() {
        Toast.makeText(this, "Pronto!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_login)
    public void authenticateLoginForm() {
        Intent x = new Intent(this, NetworkErrorActivity.class);
        startActivity(x);

    }
}
