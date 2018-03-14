package com.example.sergiomoral.appcitas.presentation.ui.view.NetworkErrorActivity;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.NetworkError.NetworkErrorPresenter;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by sergiomoral on 10/12/17.
 */

public class NetworkErrorActivity extends BaseActivity implements NetworkErrorView {


    @Inject
    NetworkErrorPresenter mPresenter;

    @Inject
    DialogManager mDialogManager;

    @Override
    protected void initInjector() {
        DaggerActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected void initUI() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_network_error;
    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }

    @OnClick(R.id.btn_retry)
    public void retryConnection() {
        if (checkConnectivity(this)) {
            goToLogin();
        } else {
            mDialogManager.showNetworkError(R.string.error_connection);
        }
    }
}
