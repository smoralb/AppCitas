package com.example.sergiomoral.appcitas.presentation.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.sergiomoral.appcitas.Appointments;

/**
 * Created by sergiomoral on 8/2/18.
 */


public class CanaroTextView extends TextView {

    public CanaroTextView(Context context) {
        this(context, null);
    }

    public CanaroTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanaroTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(Appointments.canaroExtraBold);
    }

}
