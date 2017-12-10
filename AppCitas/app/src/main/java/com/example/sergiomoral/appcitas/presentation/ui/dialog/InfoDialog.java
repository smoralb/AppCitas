package com.example.sergiomoral.appcitas.presentation.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sergiomoral.appcitas.R;

/**
 * Created by sergiomoral on 20/11/17.
 */

public class InfoDialog extends DialogFragment {

    private DialogListener mDialogListener;

    private TextView titleTextView;
    private TextView contentTextView;
    private ImageView iconImageView;

    private String titleText;
    private String contentText;
    @DrawableRes
    private int mIconResId;
    @StringRes
    private int mPositiveTextId;
    @StringRes
    private int mNegativeTextId;
    @StringRes
    private int mNeutralTextId;

    public InfoDialog() {
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public void setIconResId(@DrawableRes int iconResId) {
        mIconResId = iconResId;
    }

    public void setPositiveTextId(@StringRes int positiveTextId) {
        mPositiveTextId = positiveTextId;
    }

    public void setNegativeTextId(@StringRes int negativeTextId) {
        mNegativeTextId = negativeTextId;
    }

    public void setNeutralTextId(@StringRes int neutralTextId) {
        mNeutralTextId = neutralTextId;
    }

    public void setLlolloDialogListener(DialogListener llolloDialogListener) {
        mDialogListener = llolloDialogListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.fragment_info_dialog, null);
        titleTextView = (TextView) view.findViewById(R.id.tv_title);
        contentTextView = (TextView) view.findViewById(R.id.tv_content);
        iconImageView = (ImageView) view.findViewById(R.id.iv_icon);

        builder.setView(view)
                .setPositiveButton(mPositiveTextId, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (mDialogListener != null) {
                            mDialogListener.onDialogPositiveClick(InfoDialog.this);
                        }
                    }
                });

        if (mNegativeTextId != 0) {
            builder.setNegativeButton(mNegativeTextId, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (mDialogListener != null) {
                        mDialogListener.onDialogNegativeClick(InfoDialog.this);
                    }
                }
            });
        }

        if (mNeutralTextId != 0) {
            builder.setNeutralButton(mNeutralTextId, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (mDialogListener != null) {
                        mDialogListener.onDialogNeutralClick(InfoDialog.this);
                    }
                }
            });
        }

        initView();

        final AlertDialog dialog = builder.create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                final int color = ContextCompat.getColor(getActivity(), R.color.colorPrimary);

                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(color);
                dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(color);
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(color);
            }
        });

        dialog.setCanceledOnTouchOutside(false);

        return dialog;
    }

    private void initView() {
        titleTextView.setText(titleText);

        if (TextUtils.isEmpty(contentText)) {
            contentTextView.setVisibility(View.GONE);
        } else {
            contentTextView.setVisibility(View.VISIBLE);
            contentTextView.setText(contentText);
            contentTextView.setLineSpacing(0f, 1.2f);
        }

        if (mIconResId != 0) {
            iconImageView.setImageResource(mIconResId);
        }
    }

    public interface DialogListener {
        void onDialogPositiveClick(DialogFragment dialog);

        void onDialogNegativeClick(DialogFragment dialog);

        void onDialogNeutralClick(DialogFragment dialog);
    }
}
