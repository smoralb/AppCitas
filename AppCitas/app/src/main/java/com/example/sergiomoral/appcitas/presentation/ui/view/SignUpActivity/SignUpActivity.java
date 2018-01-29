package com.example.sergiomoral.appcitas.presentation.ui.view.SignUpActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.sergiomoral.appcitas.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 18/11/17.
 */

public class SignUpActivity extends AppCompatActivity {

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

    @OnClick(R.id.btn_signup)
    public void authenticateForm() {
        if (isValid()) {
            Toast.makeText(this, "Logeado", Toast.LENGTH_SHORT).show();
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

}
