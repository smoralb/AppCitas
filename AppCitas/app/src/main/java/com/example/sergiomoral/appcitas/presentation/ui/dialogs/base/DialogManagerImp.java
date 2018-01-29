package com.example.sergiomoral.appcitas.presentation.ui.dialogs.base;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sergiomoral.appcitas.presentation.ui.dialogs.ErrorDialog;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.LoadingDialog;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 25/1/18.
 */

public class DialogManagerImp implements DialogManager{


    public static final String TAG_LOADING_DIALOG = "loadingDialog";

    private Activity mActivity;

    @Inject
    LoadingDialog mLoadingDialog;


    @Inject
    public DialogManagerImp (Activity activity){
        mActivity = activity;
    }

    @Override
    public void showEmptyFieldsError(String message) {
        ErrorDialog errorDialog = new ErrorDialog();
        errorDialog.setErrorTitle("Se ha producido un error");
        errorDialog.setErrorMessage(message);
        show(errorDialog);

        /*mErrorDialog.setErrorMessage(message);
        mErrorDialog.show(mActivity.getFragmentManager(), TAG_LOADING_DIALOG);
        show(mErrorDialog);*/
    }

    @Override
    public void showLoginError(int message) {

    }

    @Override
    public void showLoading() {
        mLoadingDialog.show(mActivity.getFragmentManager(), TAG_LOADING_DIALOG);
    }

    @Override
    public void hideLoading() {
        try {
            mLoadingDialog.dismiss();
        } catch (Exception e) {
            Log.d("Loading error closing","Cannot close loading");
        }
    }

    private void show(@NonNull BaseDialog baseDialog) {
        try {
            if (mActivity != null && !mActivity.isFinishing()) {
                baseDialog.show(mActivity.getFragmentManager(), baseDialog.getClass().getSimpleName());
            }
        } catch (Exception e) {
            Log.d("Error", "Couldn't show dialog");
        }
    }
}
