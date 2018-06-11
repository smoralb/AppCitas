package com.example.sergiomoral.appcitas.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sergiomoral on 9/6/18.
 */

public class Center implements Parcelable {

    private String ciudad;
    private String codpostal;
    private String direccion;
    private String idcentro;
    private int latitud;
    private String localidad;
    private int longitud;
    private String nombrelocal;
    private String numvia;
    private String servicio;
    private String telefono;
    private String tipocentro;
    private String tipovia;


    private Center(Builder builder) {
        ciudad = builder.ciudad;
        codpostal = builder.codpostal;
        direccion = builder.direccion;
        idcentro = builder.idcentro;
        latitud = builder.latitud;
        localidad = builder.localidad;
        longitud = builder.longitud;
        nombrelocal = builder.nombrelocal;
        numvia = builder.numvia;
        servicio = builder.servicio;
        telefono = builder.telefono;
        tipocentro = builder.tipocentro;
        tipovia = builder.tipovia;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ciudad);
        dest.writeString(this.codpostal);
        dest.writeString(this.direccion);
        dest.writeString(this.idcentro);
        dest.writeInt(this.latitud);
        dest.writeString(this.localidad);
        dest.writeInt(this.longitud);
        dest.writeString(this.nombrelocal);
        dest.writeString(this.numvia);
        dest.writeString(this.servicio);
        dest.writeString(this.telefono);
        dest.writeString(this.tipocentro);
        dest.writeString(this.tipovia);
    }

    public Center() {
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdcentro() {
        return idcentro;
    }

    public void setIdcentro(String idcentro) {
        this.idcentro = idcentro;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getNombrelocal() {
        return nombrelocal;
    }

    public void setNombrelocal(String nombrelocal) {
        this.nombrelocal = nombrelocal;
    }

    public String getNumvia() {
        return numvia;
    }

    public void setNumvia(String numvia) {
        this.numvia = numvia;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipocentro() {
        return tipocentro;
    }

    public void setTipocentro(String tipocentro) {
        this.tipocentro = tipocentro;
    }

    public String getTipovia() {
        return tipovia;
    }

    public void setTipovia(String tipovia) {
        this.tipovia = tipovia;
    }

    protected Center(Parcel in) {
        this.ciudad = in.readString();
        this.codpostal = in.readString();
        this.direccion = in.readString();
        this.idcentro = in.readString();
        this.latitud = in.readInt();
        this.localidad = in.readString();
        this.longitud = in.readInt();
        this.nombrelocal = in.readString();
        this.numvia = in.readString();
        this.servicio = in.readString();
        this.telefono = in.readString();
        this.tipocentro = in.readString();
        this.tipovia = in.readString();
    }

    public static final Creator<Center> CREATOR = new Creator<Center>() {
        @Override
        public Center createFromParcel(Parcel source) {
            return new Center(source);
        }

        @Override
        public Center[] newArray(int size) {
            return new Center[size];
        }
    };


    public static final class Builder {
        private String ciudad;
        private String codpostal;
        private String direccion;
        private String idcentro;
        private int latitud;
        private String localidad;
        private int longitud;
        private String nombrelocal;
        private String numvia;
        private String servicio;
        private String telefono;
        private String tipocentro;
        private String tipovia;

        public Builder() {
        }

        public Builder ciudad(String val) {
            ciudad = val;
            return this;
        }

        public Builder codpostal(String val) {
            codpostal = val;
            return this;
        }

        public Builder direccion(String val) {
            direccion = val;
            return this;
        }

        public Builder idcentro(String val) {
            idcentro = val;
            return this;
        }

        public Builder latitud(int val) {
            latitud = val;
            return this;
        }

        public Builder localidad(String val) {
            localidad = val;
            return this;
        }

        public Builder longitud(int val) {
            longitud = val;
            return this;
        }

        public Builder nombrelocal(String val) {
            nombrelocal = val;
            return this;
        }

        public Builder numvia(String val) {
            numvia = val;
            return this;
        }

        public Builder servicio(String val) {
            servicio = val;
            return this;
        }

        public Builder telefono(String val) {
            telefono = val;
            return this;
        }

        public Builder tipocentro(String val) {
            tipocentro = val;
            return this;
        }

        public Builder tipovia(String val) {
            tipovia = val;
            return this;
        }

        public Center build() {
            return new Center(this);
        }
    }
}
