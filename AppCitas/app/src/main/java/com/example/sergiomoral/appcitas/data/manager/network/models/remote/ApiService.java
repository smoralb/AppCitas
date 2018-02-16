package com.example.sergiomoral.appcitas.data.manager.network.models.remote;

import com.example.sergiomoral.appcitas.data.manager.network.models.AppointmentList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sergiomoral on 14/2/18.
 */

public interface ApiService {

    @GET("LISTACITAS")
    Call<AppointmentList> getAppointments();

}
