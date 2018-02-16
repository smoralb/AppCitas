package com.example.sergiomoral.appcitas.data.manager.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sergiomoral on 14/2/18.
 */

public class Office {
    @SerializedName("nombrelocal")
    @Expose
    private String nombrelocal;
    @SerializedName("ciudad")
    @Expose
    private String ciudad;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("tipovia")
    @Expose
    private String tipovia;
    @SerializedName("codpostal")
    @Expose
    private String codpostal;
    @SerializedName("tipocentro")
    @Expose
    private String tipocentro;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("numvia")
    @Expose
    private String numvia;

    public String getNombrelocal() {
        return nombrelocal;
    }

    public void setNombrelocal(String nombrelocal) {
        this.nombrelocal = nombrelocal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipovia() {
        return tipovia;
    }

    public void setTipovia(String tipovia) {
        this.tipovia = tipovia;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getTipocentro() {
        return tipocentro;
    }

    public void setTipocentro(String tipocentro) {
        this.tipocentro = tipocentro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumvia() {
        return numvia;
    }

    public void setNumvia(String numvia) {
        this.numvia = numvia;
    }

}