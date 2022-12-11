package com.example.gymgenix;

import android.os.Parcel;
import android.os.Parcelable;

public class Seance implements Parcelable {
    public static final Creator<Seance> CREATOR = new Creator<Seance>() {
        @Override
        public Seance createFromParcel(Parcel in) {
            return new Seance(in);
        }

        @Override
        public Seance[] newArray(int size) {
            return new Seance[size];
        }
    };
    private int id;
    private String name;

    public Seance(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public Seance() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
