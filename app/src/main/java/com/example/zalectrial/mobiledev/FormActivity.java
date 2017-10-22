package com.example.zalectrial.mobiledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormActivity extends AppCompatActivity {

    Image image;
    View[] views = new View[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        image = getIntent().getExtras().getParcelable(String.valueOf(R.string.image));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        final EditText imageName = (EditText) findViewById(R.id.image_name);
        imageName.setText(image.name);
        views[0] = imageName;

        final EditText imageLocation = (EditText) findViewById(R.id.image_location);
        if (image.URL != null) {
            imageLocation.setText(image.URL);
        }
        else {
            imageLocation.setHint("URL");
        }
        views[1] = imageLocation;

        final EditText imageKeywords = (EditText) findViewById(R.id.image_keywords);
        if (image.keywords != null) {
            imageKeywords.setText(image.keywords);
        }
        else {
            imageKeywords.setHint("keywords");
        }
        views[2] = imageKeywords;

        final DatePicker imageDate = (DatePicker) findViewById(R.id.image_date);
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(image.date);
        imageDate.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                cal.set(year, monthOfYear, dayOfMonth);
            }
        });
        views[3] = imageDate;

        final ToggleButton shareButton = (ToggleButton) findViewById(R.id.image_share);
        shareButton.setChecked(image.share == 1);
        views[4] = shareButton;

        final EditText imageOwner = (EditText) findViewById(R.id.image_owner);
        if (image.email != null) {
            imageOwner.setText(image.email);
        }
        else {
            imageOwner.setHint("E-mail");
        }
        views[5] = imageOwner;

        final EditText imageRating = (EditText) findViewById(R.id.image_rating);
        if (image.rating != 0) {
            imageRating.setText(String.valueOf(image.rating));
        }
        else {
            imageRating.setHint("3.5");
        }
        views[6] = imageRating;

        Button saveButton = (Button) findViewById(R.id.save_data);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Image tempImage = image;

                if (imageName.getText() != null) { tempImage.setName(String.valueOf(imageName.getText())); }
                if (imageLocation.getText() != null) { tempImage.setURL(String.valueOf(imageLocation.getText())); }
                if (imageKeywords.getText() != null) { tempImage.setKeywords(String.valueOf(imageKeywords.getText())); }
                tempImage.setDate(cal.getTimeInMillis());
                tempImage.setShare(shareButton.isChecked() ? 1 : 0);
                if (imageOwner.getText() != null) { tempImage.setEmail(String.valueOf(imageOwner.getText())); }
                if (imageRating.getText() != null) { tempImage.setRating(Double.parseDouble(String.valueOf(imageRating.getText()))); }

                for (int i = 0; i < MainActivity.images.length; i++) {
                    if (MainActivity.images[i].name.equals(image.name)) {
                        MainActivity.images[i] = tempImage;
                    }
                }
            }
        });
    }
}
