package com.example.sergiomoral.appcitas.presentation.dialogs.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergiomoral.appcitas.Appointments;
import com.example.sergiomoral.appcitas.presentation.di.components.AppComponent;

import butterknife.ButterKnife;
import fr.tvbarthel.lib.blurdialogfragment.BlurDialogFragment;

/**
 * Created by sergiomoral on 10/12/17.
 */

public abstract class BaseDialog extends BlurDialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        //Check if there are any error with the layout or getting the reference of the layout
        if (getLayoutId() != 0) {
            view = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, view);
        }
        initUI();
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initUI();

    protected AppComponent getAppComponent() {
        return ((Appointments) getActivity().getApplication()).getAppComponent();
    }
}
