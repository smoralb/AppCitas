package com.example.sergiomoral.appcitas.presentation.ui.dialogs;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.BaseDialog;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 25/1/18.
 */

public class LoadingDialog extends BaseDialog{

    @Inject
    public LoadingDialog(){

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_loading_dialog;
    }

    @Override
    protected void initUI() {
        setCancelable(false);
    }
}
