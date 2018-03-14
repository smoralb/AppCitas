package com.example.sergiomoral.appcitas.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sergiomoral on 26/2/18.
 */

public class Office implements Parcelable {


    private String nombrelocal;
    private String ciudad;
    private String telefono;
    private String tipovia;
    private String codpostal;
    private String tipocentro;
    private String direccion;
    private String numvia;

    private Office(Builder builder) {
        nombrelocal = builder.nombrelocal;
        ciudad = builder.ciudad;
        telefono = builder.telefono;
        tipovia = builder.tipovia;
        codpostal = builder.codpostal;
        tipocentro = builder.tipocentro;
        direccion = builder.direccion;
        numvia = builder.numvia;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombrelocal);
        dest.writeString(this.ciudad);
        dest.writeString(this.telefono);
        dest.writeString(this.tipovia);
        dest.writeString(this.codpostal);
        dest.writeString(this.tipocentro);
        dest.writeString(this.direccion);
        dest.writeString(this.numvia);
    }

    public Office() {
    }

    protected Office(Parcel in) {
        this.nombrelocal = in.readString();
        this.ciudad = in.readString();
        this.telefono = in.readString();
        this.tipovia = in.readString();
        this.codpostal = in.readString();
        this.tipocentro = in.readString();
        this.direccion = in.readString();
        this.numvia = in.readString();
    }

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

    public static final Creator<Office> CREATOR = new Creator<Office>() {
        @Override
        public Office createFromParcel(Parcel source) {
            return new Office(source);
        }

        @Override
        public Office[] newArray(int size) {
            return new Office[size];
        }
    };


    public static final class Builder {
        private String nombrelocal;
        private String ciudad;
        private String telefono;
        private String tipovia;
        private String codpostal;
        private String tipocentro;
        private String direccion;
        private String numvia;

        public Builder() {
        }

        public Builder nombrelocal(String val) {
            nombrelocal = val;
            return this;
        }

        public Builder ciudad(String val) {
            ciudad = val;
            return this;
        }

        public Builder telefono(String val) {
            telefono = val;
            return this;
        }

        public Builder tipovia(String val) {
            tipovia = val;
            return this;
        }

        public Builder codpostal(String val) {
            codpostal = val;
            return this;
        }

        public Builder tipocentro(String val) {
            tipocentro = val;
            return this;
        }

        public Builder direccion(String val) {
            direccion = val;
            return this;
        }

        public Builder numvia(String val) {
            numvia = val;
            return this;
        }

        public Office build() {
            return new Office(this);
        }
    }
}
