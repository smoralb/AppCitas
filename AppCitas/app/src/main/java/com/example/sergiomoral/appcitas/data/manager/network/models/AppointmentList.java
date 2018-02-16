package com.example.sergiomoral.appcitas.data.manager.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sergiomoral on 14/2/18.
 */

public class AppointmentList {

    @SerializedName("LISTACITAS")
    @Expose
    private List<Appointment> lISTACITAS = null;

    public List<Appointment> getLISTACITAS() {
        return lISTACITAS;
    }

    public void setLISTACITAS(List<Appointment> lISTACITAS) {
        this.lISTACITAS = lISTACITAS;
    }

}
