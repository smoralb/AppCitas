package com.example.sergiomoral.appcitas.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 * Created by sergiomoral on 26/2/18.
 */

public class Appointment implements Parcelable {

    private String fechacita;
    private String horacita;
    private Office oficina;
    private String userID;
    private String estado;
    private String key;

    private Appointment(Builder builder) {
        fechacita = builder.fechacita;
        horacita = builder.horacita;
        oficina = builder.oficina;
        userID = builder.userID;
        estado = builder.estado;
        key = builder.key;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fechacita);
        dest.writeString(this.horacita);
        dest.writeParcelable(this.oficina, flags);
        dest.writeString(this.userID);
        dest.writeString(this.estado);
        dest.writeString(this.key);
    }

    public Appointment() {
    }

    protected Appointment(Parcel in) {
        this.fechacita = in.readString();
        this.horacita = in.readString();
        this.oficina = in.readParcelable(Office.class.getClassLoader());
        this.userID = in.readString();
        this.estado = in.readString();
        this.key = in.readString();
    }

    public static final Creator<Appointment> CREATOR = new Creator<Appointment>() {
        @Override
        public Appointment createFromParcel(Parcel source) {
            return new Appointment(source);
        }

        @Override
        public Appointment[] newArray(int size) {
            return new Appointment[size];
        }
    };

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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public static final class Builder {
        private String fechacita;
        private String horacita;
        private Office oficina;
        private String userID;
        private String estado;
        private String key;

        public Builder() {
        }

        public Builder fechacita(String val) {
            fechacita = val;
            return this;
        }

        public Builder horacita(String val) {
            horacita = val;
            return this;
        }

        public Builder oficina(Office val) {
            oficina = val;
            return this;
        }

        public Builder userID(String val) {
            userID = val;
            return this;
        }

        public Builder estado(String val) {
            estado = val;
            return this;
        }

        public Builder key(String val) {
            key = val;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }
}
