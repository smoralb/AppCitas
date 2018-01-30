package com.example.sergiomoral.appcitas.presentation.ui.dialogs;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.BaseDialog;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by sergiomoral on 25/1/18.
 */

public class ErrorDialog extends BaseDialog {

    @BindView(R.id.error_title)
    TextView errorTitle;

    @BindView(R.id.error_message)
    TextView errorMessage;

    @BindView(R.id.btn_ok)
    Button btnAccept;

    @Nullable
    private int msg;


    @Inject
    public ErrorDialog() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_error_dialog;
    }

    @Override
    protected void initUI() {
        setCancelable(false);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Close dialog
                dismiss();
            }
        });
        if (getString(msg) != null) {
            errorMessage.setText(getString(msg));
        }

        //if (getString(title) != null) {
        errorTitle.setText(getString(R.string.error_title));
        //}
    }


    public void setErrorMessage(@Nullable int msg) {
        this.msg = msg;
    }
}
