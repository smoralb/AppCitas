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
    private String localidad;
    private String email;
    private Double latitud;
    private Double longitud;
    private String logo;

    private Office(Builder builder) {
        nombrelocal = builder.nombrelocal;
        ciudad = builder.ciudad;
        telefono = builder.telefono;
        tipovia = builder.tipovia;
        codpostal = builder.codpostal;
        tipocentro = builder.tipocentro;
        direccion = builder.direccion;
        numvia = builder.numvia;
        localidad = builder.localidad;
        email = builder.email;
        latitud = builder.latitud;
        longitud = builder.longitud;
        logo = builder.logo;
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
        dest.writeString(this.localidad);
        dest.writeString(this.email);
        dest.writeValue(this.latitud);
        dest.writeValue(this.longitud);
        dest.writeString(this.logo);
    }

    public Office() {
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
        this.localidad = in.readString();
        this.email = in.readString();
        this.latitud = (Double) in.readValue(Double.class.getClassLoader());
        this.longitud = (Double) in.readValue(Double.class.getClassLoader());
        this.logo = in.readString();
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
        private String localidad;
        private String email;
        private Double latitud;
        private Double longitud;
        private String logo;

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

        public Builder localidad(String val) {
            localidad = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder latitud(Double val) {
            latitud = val;
            return this;
        }

        public Builder longitud(Double val) {
            longitud = val;
            return this;
        }

        public Builder logo(String val) {
            logo = val;
            return this;
        }

        public Office build() {
            return new Office(this);
        }
    }
}

