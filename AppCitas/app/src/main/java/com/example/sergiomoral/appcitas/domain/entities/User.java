package com.example.sergiomoral.appcitas.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sergiomoral on 14/3/18.
 */

public class User implements Parcelable {

    private String name;
    private String apellido1;
    private String apellido2;
    private String email;
    private String userId;
    private String mobilePhone;
    private String password;

    private User(Builder builder) {
        name = builder.name;
        apellido1 = builder.apellido1;
        apellido2 = builder.apellido2;
        email = builder.email;
        userId = builder.userId;
        mobilePhone = builder.mobilePhone;
        password = builder.password;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.apellido1);
        dest.writeString(this.apellido2);
        dest.writeString(this.email);
        dest.writeString(this.userId);
        dest.writeString(this.mobilePhone);
        dest.writeString(this.password);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.apellido1 = in.readString();
        this.apellido2 = in.readString();
        this.email = in.readString();
        this.userId = in.readString();
        this.mobilePhone = in.readString();
        this.password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final class Builder {
        private String name;
        private String apellido1;
        private String apellido2;
        private String email;
        private String userId;
        private String mobilePhone;
        private String password;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder apellido1(String val) {
            apellido1 = val;
            return this;
        }

        public Builder apellido2(String val) {
            apellido2 = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public Builder mobilePhone(String val) {
            mobilePhone = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
