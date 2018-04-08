package com.example.sergiomoral.appcitas.presentation.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.example.sergiomoral.appcitas.Appointments;
import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.di.components.ApplicationComponent;
import com.example.sergiomoral.appcitas.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by sergiomoral on 16/3/18.
 */

public abstract class BaseFragment extends Fragment {


    @Inject
    public DialogManager mDialogManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        int layoutId = getLayoutId();
        if (layoutId != 0) {
            view = inflater.inflate(layoutId, container, false);
            ButterKnife.bind(this, view);
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public abstract int getLayoutId();

    public abstract void initializeInjector();

    public abstract void initUi();

    public abstract void attachViewToPresenter();

    public void showLoading() {
        mDialogManager.showLoading();
    }

    public void hideLoading() {
        mDialogManager.hideLoading();
    }

    public void showError(int message) {
        mDialogManager.showErrorSignUp(R.drawable.ic_error, R.string.generic_error, message);
    }

    protected ApplicationComponent getAppComponent() {
        return ((Appointments) getActivity().getApplication()).getAppComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(getActivity());
    }

}
