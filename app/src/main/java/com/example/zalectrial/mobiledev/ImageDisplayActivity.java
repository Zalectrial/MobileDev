package com.example.zalectrial.mobiledev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);
        ImageView image = (ImageView) findViewById(R.id.image);
        TextView description = (TextView) findViewById(R.id.image_desc);
        int image_name = getIntent().getExtras().getInt(getString(R.string.imageName));
        image.setImageDrawable(getDrawable(image_name));
        description.setText(getIntent().getExtras().getCharSequence(getString(R.string.imageDesc)));
    }
}
