package com.example.sergiomoral.appcitas.presentation.dialogs;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.dialogs.base.BaseDialog;

import butterknife.BindDrawable;
import butterknife.BindView;

/**
 * Created by sergiomoral on 10/12/17.
 */

public class LoadingDialog extends BaseDialog{

    @BindView(R.id.tv_loading_dialog)
    TextView mLoadingLabel;

    @BindDrawable(android.R.color.transparent)
    Drawable mTransparent;

    String msg;


    @Override
    protected int getLayoutId() {
        return R.layout.dialog_loading;
    }

    @Override
    protected void initUI() {
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(mTransparent);
        }

        if (msg != null) {
            mLoadingLabel.setText(msg);
        }

        setCancelable(false);

    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
