package com.example.zalectrial.mobiledev;

import android.os.Parcel;
import android.os.Parcelable;

class Image implements Parcelable {
    String name;
    String URL;
    String[] keywords;
    long date;
    String email;
    int rating;

    public Image(String name, long date) {
        this.name = name;
        this.date = date;
    }

    private Image(Parcel in) {
        name = in.readString();
        URL = in.readString();
        keywords = in.createStringArray();
        date = in.readLong();
        email = in.readString();
        rating = in.readInt();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(URL);
        dest.writeStringArray(keywords);
        dest.writeLong(date);
        dest.writeString(email);
        dest.writeInt(rating);
    }
}
