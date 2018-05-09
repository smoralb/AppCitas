package com.example.sergiomoral.appcitas.presentation.ui.view.DetailsActivity;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;
import com.example.sergiomoral.appcitas.presentation.utils.Utils;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergiomoral on 15/4/18.
 */

public class AppointmentDetailsActivity extends BaseActivity implements AppointmentDetailsView {

    @BindView(R.id.tv_commerce_name)
    TextView mCommerceName;

    @BindView(R.id.tv_appointment_date)
    TextView mAppointmentDate;

    @BindView(R.id.tv_appointment_hour)
    TextView mAppointmentHour;

    @BindView(R.id.tv_commerce_address)
    TextView mCommerceAddress;

    @BindView(R.id.tv_commerce_mail)
    TextView mCommerceMail;

    @BindView(R.id.tv_commerce_phone)
    TextView mCommercePhone;

    @BindView(R.id.iv_commerce_location)
    ImageView mCommerceLocation;

    @Inject
    DialogManager mDialogManager;

    public String url;


    @Override
    protected void initInjector() {
        DaggerActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected void initUI() {


        Appointment appointmentSelected = (Appointment) getIntent().getExtras().get(BuildData.ITEM_APPOINTMENT);

        if (appointmentSelected != null) {

            url = "http://maps.google.com/maps/api/staticmap?center=" + appointmentSelected.getOficina().getLatitud() + ","
                    + appointmentSelected.getOficina().getLongitud()
                    + "&zoom=15&"
                    + "size=400x200"
                    + "&sensor=false&markers=color:green%7Clabel:G%7C"
                    + appointmentSelected.getOficina().getLatitud()
                    + ", "
                    + appointmentSelected.getOficina().getLongitud()
                    + "&key="
                    + getString(R.string.google_api_key);


            loadMapPreview();

            String road = appointmentSelected.getOficina().getDireccion();
            String city = appointmentSelected.getOficina().getCiudad();
            String zipCode = appointmentSelected.getOficina().getCodpostal();
            String numVia = appointmentSelected.getOficina().getNumvia();
            String roadType = appointmentSelected.getOficina().getTipovia();
            String localidad = appointmentSelected.getOficina().getLocalidad();
            String email = appointmentSelected.getOficina().getEmail();
            String phone = appointmentSelected.getOficina().getTelefono();

            mCommerceName.setText(appointmentSelected.getOficina().getNombrelocal());
            mAppointmentDate.setText(appointmentSelected.getFechacita());
            mAppointmentHour.setText(appointmentSelected.getHoracita());
            mCommerceAddress.setText(Utils.addressFormat(roadType, localidad, road, city, numVia, zipCode));

        } else
            mDialogManager.showError(R.drawable.ic_error, R.string.generic_title_error, R.string.generic_error, this);
    }


    public void loadMapPreview() {
        //start a background thread for networking
        new Thread(new Runnable() {
            public void run() {
                try {
                    //download the drawable
                    final Drawable drawable = Drawable.createFromStream((InputStream) new URL(url).getContent(), "src");
                    //edit the view in the UI thread
                    mCommerceLocation.post(new Runnable() {
                        public void run() {
                            mCommerceLocation.setImageDrawable(drawable);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @OnClick(R.id.btn_modify)
    public void modifyAppointment() {
        // TODO: 8/5/18 Accion de modificar cita
    }

    @OnClick(R.id.btn_delete)
    public void deleteAppointment() {
        // TODO: 8/5/18 Accion de eliminar cita
    }

    @OnClick(R.id.iv_back)
    public void onBack() {
        finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_appointment_details;
    }


    @Override
    public void attachViewToPresenter() {

    }

}
