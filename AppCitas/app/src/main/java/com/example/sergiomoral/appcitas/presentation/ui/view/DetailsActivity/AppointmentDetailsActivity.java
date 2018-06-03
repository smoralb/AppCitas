package com.example.sergiomoral.appcitas.presentation.ui.view.DetailsActivity;

import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.presentation.base.BaseActivity;
import com.example.sergiomoral.appcitas.presentation.di.components.DaggerActivityComponent;
import com.example.sergiomoral.appcitas.presentation.ui.dialogs.base.DialogManager;
import com.example.sergiomoral.appcitas.presentation.ui.presenter.appointmentDetails.AppointmentDetailsPresenter;
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

    @BindView(R.id.iv_commerce_logo)
    ImageView mCommerceLogo;

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

    @Inject
    AppointmentDetailsPresenter mPresenter;

    public String url;
    public Appointment mAppointment;


    @Override
    protected void initInjector() {
        DaggerActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected void initUI() {


        mAppointment = (Appointment) getIntent().getExtras().get(BuildData.ITEM_APPOINTMENT);

        if (mAppointment != null) {

            url = "http://maps.google.com/maps/api/staticmap?center=" + mAppointment.getOficina().getLatitud() + ","
                    + mAppointment.getOficina().getLongitud()
                    + "&zoom=15&"
                    + "size=400x200"
                    + "&sensor=false&markers=color:green%7Clabel:G%7C"
                    + mAppointment.getOficina().getLatitud()
                    + ", "
                    + mAppointment.getOficina().getLongitud()
                    + "&key="
                    + getString(R.string.google_api_key);


            loadMapPreview();

            String road = mAppointment.getOficina().getDireccion();
            String city = mAppointment.getOficina().getCiudad();
            String zipCode = mAppointment.getOficina().getCodpostal();
            String numVia = mAppointment.getOficina().getNumvia();
            String roadType = mAppointment.getOficina().getTipovia();
            String localidad = mAppointment.getOficina().getLocalidad();
            String email = mAppointment.getOficina().getEmail();
            String phone = mAppointment.getOficina().getTelefono();
            String logo = mAppointment.getOficina().getLogo();
            byte[] logoEncoded = Base64.decode(logo, Base64.DEFAULT);

            mCommerceLogo.setImageBitmap(Utils.getBitmapFromBase64(logoEncoded));
            mCommerceName.setText(mAppointment.getOficina().getNombrelocal());
            mAppointmentDate.setText(mAppointment.getFechacita());
            mAppointmentHour.setText(mAppointment.getHoracita());
            mCommerceAddress.setText(Utils.addressFormat(roadType, localidad, road, city, numVia, zipCode));

            if (email != null) {
                mCommerceMail.setText(email);
            } else {
                mCommerceMail.setText(R.string.email_not_disponible);
            }
            if (phone != null) {
                mCommercePhone.setText(phone);
            } else {
                mCommercePhone.setText(R.string.phone_not_disponible);
            }
            mCommercePhone.setText(phone);

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
        Toast.makeText(this, "Falta por implementar", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_delete)
    public void deleteAppointment() {

        mDialogManager.showAlert(R.string.dialog_warning_title, R.string.dialog_warning_message, this, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialogManager.hideAlertDialog();
                mPresenter.deleteAppointment(mAppointment);
            }
        });
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
        mPresenter.attachView(this);
    }

    @Override
    public void goToAppointments() {
        finish();
    }
}
