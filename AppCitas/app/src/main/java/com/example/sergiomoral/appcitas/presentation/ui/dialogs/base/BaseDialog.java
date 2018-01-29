package com.example.sergiomoral.appcitas.presentation.ui.dialogs.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergiomoral.appcitas.Appointments;
import com.example.sergiomoral.appcitas.presentation.di.components.ApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.ActivityModule;

import javax.annotation.Nullable;

import butterknife.ButterKnife;
import fr.tvbarthel.lib.blurdialogfragment.BlurDialogFragment;

/**
 * Created by sergiomoral on 25/1/18.
 */

public abstract class BaseDialog extends BlurDialogFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        if (getLayoutId() != 0){
            view = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this,view);
            ButterKnife.setDebug(true);
        }

        initUI();
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initUI();

    // BaseDialog needs the AppComponent to initilize the injector in the classes that extends from BaseDialog (LoadingDialog, ErrorDialog)
    protected ApplicationComponent getAppComponent() {
        return ((Appointments)getActivity().getApplication()).getAppComponent();
    }
    // Also needs ActivityModule to initialize the injector in the classes that extends from BaseDialog (LoadingDialog, ErrorDialog)
    protected ActivityModule getActivityModule(){
        return new ActivityModule(getActivity());
    }

    //This is a method from BlurDialogFragment library
    @Override
    protected int getBlurRadius(){
        return 10;
    }

}
