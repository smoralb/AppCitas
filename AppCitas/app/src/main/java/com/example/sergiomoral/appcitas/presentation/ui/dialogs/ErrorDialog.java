package com.example.sergiomoral.appcitas.presentation.ui.dialogs;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.BaseDialog;

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
    private String msg;

    @Nullable
    private String title;


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
        if (msg != null) {
            errorMessage.setText(msg);
        }

        if (title != null) {
            errorTitle.setText(title);
        }
    }

    public void setErrorTitle(@Nullable String title) {
        this.title = title;
    }

    public void setErrorMessage(@Nullable String msg) {
        this.msg = msg;
    }
}
