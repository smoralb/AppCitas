package com.example.sergiomoral.appcitas.presentation.ui.view.CreateAppointmentActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Center;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.createAppointment.CreateAppointmentPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 9/6/18.
 */

public class CreateAppointmentActivity extends BaseActivity implements CreateAppointmentView {

    @BindView(R.id.et_service)
    Spinner serviceSpinner;

    @BindView(R.id.et_stablishment)
    Spinner stablishmentSpinner;

    @BindView(R.id.et_select_location)
    Spinner locationSpinner;

    @BindView(R.id.et_select_date)
    Spinner dateSelectedSpinner;

    @BindView(R.id.et_select_hour)
    Spinner hourSelectedSpinner;


    @Inject
    CreateAppointmentPresenter mPresenter;
    private String serviceSelected;
    private Center centerSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Inject
    public CreateAppointmentActivity() {
    }

    @Override
    protected void initInjector() {
        DaggerActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected void initUI() {

        populateSpinnerService();
    }

    private void populateSpinnerStablishment() {
        mPresenter.getStablishments();
    }

    private void populateSpinnerService() {
        mPresenter.getServices(this);
    }

    @OnClick(R.id.iv_back)
    public void onBack() {
        finish();
    }

    @OnClick(R.id.btn_create_appointment)
    public void createAppointment() {
        Toast.makeText(this, "Falta implementacion", Toast.LENGTH_LONG).show();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_create_appointment;
    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }

    @Override
    public void showServices(final ArrayList<String> services) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, services);

        services.add(0, getString(R.string.select_service));

        serviceSpinner.setAdapter(adapter);

        serviceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                if (services.get(0).equals(getString(R.string.select_service))) services.remove(0);
                serviceSelected = services.get(position);
                populateSpinnerStablishment();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public void showStablishments(final ArrayList<Center> centers) {

        hideLoading();
        final ArrayList<String> centerNames = new ArrayList<>();
        for (Center center : centers) {
            if (center.getServicio().equals(serviceSelected)) {
                centerNames.add(center.getNombrelocal());
            }
        }
        centerNames.add(0, getString(R.string.select_stablishment));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, centerNames);

        stablishmentSpinner.setAdapter(adapter);
        // TODO: 9/6/18 Filtrar dependiendo del servicio seleccionado

        stablishmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (centerNames.size() > 1) {
                    if (centerNames.get(0).equals(getString(R.string.select_stablishment)))
                        centerNames.remove(0);
                    String centerName = centerNames.get(position);

                    //Get the center associated with te item selected
                    for (int i = 0; i < centers.size(); i++) {
                        if (centerName.equals(centers.get(i).getNombrelocal())) {
                            centerSelected = centers.get(i);
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
                stablishmentSpinner.setPrompt(getString(R.string.select_stablishment));

            }
        });
    }
}
