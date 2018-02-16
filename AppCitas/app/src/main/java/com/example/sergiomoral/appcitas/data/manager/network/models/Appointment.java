package com.example.sergiomoral.appcitas.data.manager.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sergiomoral on 14/2/18.
 */

public class Appointment {

    @SerializedName("idcita")
    @Expose
    private String idcita;
    @SerializedName("useremail")
    @Expose
    private String useremail;
    @SerializedName("fechacita")
    @Expose
    private String fechacita;
    @SerializedName("horacita")
    @Expose
    private String horacita;
    @SerializedName("oficina")
    @Expose
    private Office oficina;

    public String getIdcita() {
        return idcita;
    }

    public void setIdcita(String idcita) {
        this.idcita = idcita;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getFechacita() {
        return fechacita;
    }

    public void setFechacita(String fechacita) {
        this.fechacita = fechacita;
    }

    public String getHoracita() {
        return horacita;
    }

    public void setHoracita(String horacita) {
        this.horacita = horacita;
    }

    public Office getOficina() {
        return oficina;
    }

    public void setOficina(Office oficina) {
        this.oficina = oficina;
    }
}