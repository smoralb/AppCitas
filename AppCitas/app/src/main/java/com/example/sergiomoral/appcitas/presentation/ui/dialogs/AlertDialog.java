package com.example.sergiomoral.appcitas.presentation.ui.dialogs;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.BaseDialog;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by sergiomoral on 3/6/18.
 */

public class AlertDialog extends BaseDialog {

    @BindView(R.id.tv_title)
    TextView dialogTitle;

    @BindView(R.id.tv_content)
    TextView dialogMessage;

    @BindView(R.id.btn_accept)
    TextView btnAccept;

    @BindView(R.id.btn_cancel)
    TextView btnCancel;

    @Nullable
    private int msg;

    @Nullable
    private int title;

    @Nullable
    private Activity activity;

    private View.OnClickListener listener;

    @Inject
    public AlertDialog() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_alert_dialog;
    }

    @Override
    protected void initUI() {

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnAccept.setOnClickListener(listener);

        if (getString(msg) != null) {
            dialogMessage.setText(getString(msg));
        }

        if (getString(title).equals(null)) {
            dialogTitle.setText(getString(R.string.generic_error));
        } else {
            dialogTitle.setText(getString(title));
        }
    }

    public void setMsg(@Nullable int msg) {
        this.msg = msg;
    }

    public void setTitle(@Nullable int title) {
        this.title = title;
    }

    public void setActivity(@Nullable Activity activity) {
        this.activity = activity;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}
