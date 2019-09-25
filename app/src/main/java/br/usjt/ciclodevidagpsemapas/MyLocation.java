package br.usjt.ciclodevidagpsemapas;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

public class MyLocation implements Parcelable {
    private Location location;

    public MyLocation(Location l) {
        this.location = l;
    }

    @Override
    public String toString() {
        return String.format("Lat: %f, Lon: %f", this.location.getLatitude(), this.location.getLongitude());
    }

    public double getLatitude() {
        return this.location.getLatitude();
    }

    public double getLongitude() {
        return this.location.getLongitude();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.location, flags);
    }

    protected MyLocation(Parcel in) {
        this.location = in.readParcelable(Location.class.getClassLoader());
    }

    public static final Parcelable.Creator<MyLocation> CREATOR = new Parcelable.Creator<MyLocation>() {
        @Override
        public MyLocation createFromParcel(Parcel source) {
            return new MyLocation(source);
        }

        @Override
        public MyLocation[] newArray(int size) {
            return new MyLocation[size];
        }
    };
}
