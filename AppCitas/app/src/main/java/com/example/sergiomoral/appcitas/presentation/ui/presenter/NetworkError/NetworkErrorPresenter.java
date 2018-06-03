package com.example.sergiomoral.appcitas.presentation.ui.presenter.networkError;

import com.example.sergiomoral.appcitas.presentation.ui.presenter.Presenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.NetworkErrorActivity.NetworkErrorView;

import javax.inject.Inject;

/**
 * Created by sergiomoral on 7/2/18.
 */

public class NetworkErrorPresenter implements Presenter<NetworkErrorView> {

    private NetworkErrorView mView;

    @Inject
    public NetworkErrorPresenter() {

    }

    @Override
    public void attachView(NetworkErrorView view) {
        mView = view;
    }
}
