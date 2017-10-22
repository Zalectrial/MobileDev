package com.example.zalectrial.mobiledev;

import android.os.Parcel;
import android.os.Parcelable;

class Image implements Parcelable {
    String name;
    String URL;
    String keywords;
    long date;
    int share;
    String email;
    double rating;

    public Image(String name, long date) {
        this.name = name;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private Image(Parcel in) {
        name = in.readString();
        URL = in.readString();
        keywords = in.readString();
        date = in.readLong();
        share = in.readInt();
        email = in.readString();
        rating = in.readDouble();
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
        dest.writeString(keywords);
        dest.writeLong(date);
        dest.writeInt(share);
        dest.writeString(email);
        dest.writeDouble(rating);
    }
}
