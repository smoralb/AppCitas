package com.example.sergiomoral.appcitas.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by sergiomoral on 26/2/18.
 */

public class Appointment implements Parcelable {


    private String idcita;
    private String useremail;
    private String fechacita;
    private String horacita;
    private Office oficina;

    public Appointment() {

    }

    private Appointment(Builder builder) {
        setIdcita(builder.idcita);
        setUseremail(builder.useremail);
        setFechacita(builder.fechacita);
        setHoracita(builder.horacita);
        setOficina(builder.oficina);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idcita);
        dest.writeString(this.useremail);
        dest.writeString(this.fechacita);
        dest.writeString(this.horacita);
        dest.writeParcelable(this.oficina, flags);
    }

    protected Appointment(Parcel in) {
        this.idcita = in.readString();
        this.useremail = in.readString();
        this.fechacita = in.readString();
        this.horacita = in.readString();
        this.oficina = in.readParcelable(Office.class.getClassLoader());
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


    public static final class Builder {
        private String idcita;
        private String useremail;
        private String fechacita;
        private String horacita;
        private Office oficina;

        public Builder() {
        }

        public Builder idcita(String val) {
            idcita = val;
            return this;
        }

        public Builder useremail(String val) {
            useremail = val;
            return this;
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

        public Appointment build() {
            return new Appointment(this);
        }
    }
}