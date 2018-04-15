package com.example.sergiomoral.appcitas.presentation.ui.dialogs.base;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.ErrorDialog;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.LoadingDialog;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by sergiomoral on 25/1/18.
 */

public class DialogManagerImp implements DialogManager {


    public static final String TAG_LOADING_DIALOG = "loadingDialog";


    @Inject
    LoadingDialog mLoadingDialog;
    @Inject
    ErrorDialog mErrorDialog;

    @BindView(R.id.btn_ok)
    Button mButtonAccept;

    private Activity mActivity;


    @Inject
    public DialogManagerImp(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void showEmptyFieldsError(int message) {

        mErrorDialog.setErrorMessage(R.string.error_empty_field);
        show(mErrorDialog);
    }

    @Override
    public void showLoginError(int message) {

        mErrorDialog.setErrorMessage(message);
        show(mErrorDialog);
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
            Log.d("Loading error closing", "Cannot close loading");
        }
    }

    @Override
    public void showNetworkError(int msg) {
        mErrorDialog.setErrorMessage(msg);
        show(mErrorDialog);
    }

    @Override
    public void showSuccessSignUp(int icon, int title, int msg, Activity activity) {
        mErrorDialog.serErrorIcon(icon);
        mErrorDialog.setErrorTitle(title);
        mErrorDialog.setErrorMessage(msg);
        mErrorDialog.setActivity(activity);
        show(mErrorDialog);

    }

    @Override
    public void showErrorSignUp(int icon, int title, int msg, Activity activity) {
        mErrorDialog.serErrorIcon(icon);
        mErrorDialog.setErrorTitle(title);
        mErrorDialog.setErrorMessage(msg);
        mErrorDialog.setActivity(activity);
        show(mErrorDialog);
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
