package com.example.sergiomoral.appcitas.presentation.ui.dialog;

/**
 * Created by sergiomoral on 18/11/17.
 */

import android.app.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import gov.es.segsocial.R;
import gov.es.segsocial.presentation.di.qualifiers.PerActivity;
import gov.es.segsocial.utils.LogUtils;

@PerActivity
public class DialogManagerImp implements DialogManager {

    private static final String TAG = LogUtils.makeLogTag(DialogManagerImp.class);
    private final Activity mActivity;
    private ProgressDialog loadingDialog;

    @Inject
    public DialogManagerImp(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void showInfoDialog(@DrawableRes int iconId, String title, String content, DialogListener dialogListener) {
        showInfoDialog(iconId, title, content, R.string.ok, 0, dialogListener);
    }

    @Override
    public void showInfoDialog(@DrawableRes int iconId, String title, String content, @StringRes int neutralTextId,
                               final DialogListener dialogListener, final NeutralDialogListener neutralDialogListener) {

        InfoDialog infoDialog = new InfoDialog();
        infoDialog.setCancelable(true);
        infoDialog.setTitleText(title);
        infoDialog.setContentText(content);
        infoDialog.setIconResId(iconId);
        infoDialog.setPositiveTextId(R.string.ok);
        infoDialog.setNeutralTextId(neutralTextId);
        infoDialog.setLlolloDialogListener(getLlolloDialogListener(dialogListener, neutralDialogListener));

        if (!mActivity.isFinishing()) {
            infoDialog.show(((AppCompatActivity) mActivity).getSupportFragmentManager(), "info_dialog");
        }
    }

    @NonNull
    private static InfoDialog.DialogListener getLlolloDialogListener(final DialogListener dialogListener,
                                                                     final NeutralDialogListener
                                                                             neutralDialogListener) {
        return new InfoDialog.DialogListener() {
            @Override
            public void onDialogPositiveClick(DialogFragment dialog) {
                if (dialogListener != null) {
                    dialogListener.onDialogPositiveClick(dialog);
                }
            }

            @Override
            public void onDialogNegativeClick(DialogFragment dialog) {
                if (dialogListener != null) {
                    dialogListener.onDialogNegativeClick(dialog);
                }
            }

            @Override
            public void onDialogNeutralClick(DialogFragment dialog) {
                if (neutralDialogListener != null) {
                    neutralDialogListener.onDialogNeutralClick(dialog);
                }
            }
        };
    }

    @Override
    public void showInfoDialog(@DrawableRes int iconId, String title, String content, @StringRes int positiveTextId,
                               @StringRes int negativeTextId, final DialogListener dialogListener) {
        InfoDialog infoDialog = new InfoDialog();
        infoDialog.setCancelable(false);
        infoDialog.setTitleText(title);
        infoDialog.setContentText(content);
        infoDialog.setIconResId(iconId);
        infoDialog.setPositiveTextId(positiveTextId);
        infoDialog.setNegativeTextId(negativeTextId);
        infoDialog.setLlolloDialogListener(getLlolloDialogListener(dialogListener, null));

        if (!mActivity.isFinishing()) {
            infoDialog.show(((AppCompatActivity) mActivity).getSupportFragmentManager(), "info_dialog");
        }
    }

    @Override
    public void showCreateAppointmentDialog(String email, String phone,
                                            final CreateAppointmentListener createAppointmentListener) {

        CreateAppointmentDialog createAppointmentDialog = new CreateAppointmentDialog();
        createAppointmentDialog.setEmail(email);
        createAppointmentDialog.setPhone(phone);
        createAppointmentDialog.setListener(new CreateAppointmentDialog.Listener() {
            @Override
            public void onDialogPositiveClick(CreateAppointmentDialog dialog) {
                if (createAppointmentListener != null) {
                    createAppointmentListener.onCreateClick(dialog.getEmail(), dialog.getPhone());
                }
            }
        });

        createAppointmentDialog.show(mActivity.getFragmentManager(), "createAppointmentDialog");
    }

    @Override
    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new ProgressDialog(mActivity);
        }

        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
            loadingDialog.setContentView(R.layout.dialog_progress);
            loadingDialog.setCancelable(false);
        }
    }

    @Override
    public void hideLoading() {
        try {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        } catch (Exception e) {
            LogUtils.logE(TAG, "hideLoading", e);
        }
    }
}
