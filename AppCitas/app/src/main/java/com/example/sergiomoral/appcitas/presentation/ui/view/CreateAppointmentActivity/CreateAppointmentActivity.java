package com.example.sergiomoral.appcitas.presentation.ui.view.CreateAppointmentActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Office;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.createAppointment.CreateAppointmentPresenter;
import com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.AppointmentsListActivity;
import com.example.sergiomoral.appcitas.presentation.utils.DatePickerFragment;
import com.example.sergiomoral.appcitas.presentation.utils.TimePickerFragment;

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
    TextView tvDateSelected;
    @BindView(R.id.et_select_hour)
    TextView tvHourSelected;
    @BindView(R.id.iv_locality)
    ImageView ivLocality;
    @BindView(R.id.iv_stablishment)
    ImageView ivStablishment;
    @BindView(R.id.iv_service)
    ImageView ivService;
    @BindView(R.id.iv_date)
    ImageView ivDate;
    @BindView(R.id.iv_hour)
    ImageView ivHour;
    @BindView(R.id.tv_title_toolbar)
    TextView toolbarTitle;
    @BindView(R.id.iv_back)
    ImageView backButton;


    @Inject
    CreateAppointmentPresenter mPresenter;

    private Office officeSelected;
    private String serviceSelected = "";
    private String localitySelected = "";
    private String dateSelected = "";
    private String hourSelected = "";
    private boolean correctForm;
    private boolean appointmentToModify;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbarTitle.setText(R.string.create_appointment);
        if (getIntent().getExtras() != null) {
            appointmentToModify = getIntent().getBooleanExtra("modifyAppointment", false);
            initUI();
        }
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

        if (appointmentToModify){
            backButton.setVisibility(View.GONE);
            toolbarTitle.setText(R.string.modify_appointment);
        }
        populateLocalities();
        populateSpinnerService();
        populateSpinnerStablishment();
    }

    private void populateSpinnerStablishment() {
        mPresenter.getStablishments();
    }

    private void populateSpinnerService() {
        mPresenter.getServices(this);
    }

    @OnClick(R.id.iv_back)
    public void onBack() {

        Intent listActivity = new Intent(this, AppointmentsListActivity.class);
        startActivity(listActivity);
        finish();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_create_appointment;
    }

    @Override
    public void attachViewToPresenter() {
        mPresenter.attachView(this);
    }


    private void populateLocalities() {
        Resources res = getResources();
        final ArrayList<String> localitiesArray = new ArrayList<>();
        final String[] localities = res.getStringArray(R.array.localities_array);

        for (int i = 0; i < localities.length; i++) {
            localitiesArray.add(localities[i]);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, localitiesArray);
        locationSpinner.setAdapter(adapter);

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                localitySelected = localities[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });
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
    public void showStablishments(final ArrayList<Office> offices) {

        hideLoading();
        final ArrayList<String> centerNames = new ArrayList<>();
        for (Office office : offices) {
            if (office.getServicio().equals(serviceSelected)
                    && office.getCiudad().equals(localitySelected)) {
                centerNames.add(office.getNombrelocal());
            }
        }
        centerNames.add(0, getString(R.string.select_stablishment));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, centerNames);

        stablishmentSpinner.setAdapter(adapter);

        stablishmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String centerName = centerNames.get(position);
                //Get the center associated with the item selected
                for (int i = 0; i < offices.size(); i++) {
                    if (centerName.equals(offices.get(i).getNombrelocal())) {
                        officeSelected = offices.get(i);
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

    @SuppressLint("DefaultLocale")
    @OnClick(R.id.et_select_hour)
    public void populateHours() {

        TimePickerFragment newFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
                hourSelected = String.format("%02d:%02d", hour, minutes);
                tvHourSelected.setText(hourSelected);
            }
        });
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    @SuppressLint("DefaultLocale")
    @OnClick(R.id.et_select_date)
    public void populateDates() {

        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                dateSelected = String.format("%02d/%02d/%04d", day, month, year);
                tvDateSelected.setText(dateSelected);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @OnClick(R.id.btn_create_appointment)
    public void createAppointment() {
        mPresenter.processFormData(localitySelected, serviceSelected, officeSelected, dateSelected, hourSelected);
        if (correctForm) {
            mPresenter.sendDataToDataBase(localitySelected, serviceSelected, officeSelected, dateSelected, hourSelected);
        }
    }

    @Override
    public void setImageToLocality(boolean isCorrect) {
        correctForm = isCorrect;
        if (isCorrect) ivLocality.setImageDrawable(getDrawable(R.drawable.ic_ok));
        else ivLocality.setImageDrawable(getDrawable(R.drawable.ic_error));
    }

    @Override
    public void setImageToService(boolean isCorrect) {

        correctForm = isCorrect;
        if (isCorrect) ivService.setImageDrawable(getDrawable(R.drawable.ic_ok));
        else ivService.setImageDrawable(getDrawable(R.drawable.ic_error));
    }

    @Override
    public void setImageToStablishment(boolean isCorrect) {

        correctForm = isCorrect;
        if (isCorrect) ivStablishment.setImageDrawable(getDrawable(R.drawable.ic_ok));
        else ivStablishment.setImageDrawable(getDrawable(R.drawable.ic_error));
    }

    @Override
    public void setImageToDateSelected(boolean isCorrect) {

        correctForm = isCorrect;
        if (isCorrect) ivDate.setImageDrawable(getDrawable(R.drawable.ic_ok));
        else ivDate.setImageDrawable(getDrawable(R.drawable.ic_error));
    }

    @Override
    public void setImagetoHourSelected(boolean isCorrect) {

        correctForm = isCorrect;
        if (isCorrect) ivHour.setImageDrawable(getDrawable(R.drawable.ic_ok));
        else ivHour.setImageDrawable(getDrawable(R.drawable.ic_error));
    }

    @Override
    public void goToAppointmentList() {
        Intent listActivity = new Intent(this, AppointmentsListActivity.class);
        startActivity(listActivity);
        finish();
    }
}
