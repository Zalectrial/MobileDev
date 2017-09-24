package com.example.zalectrial.mobiledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    Image image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        image = getIntent().getExtras().getParcelable(String.valueOf(R.string.image));

        EditText imageName = (EditText) findViewById(R.id.image_name);
        imageName.setHint(image.name);
    }
}
