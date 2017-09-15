package com.example.zalectrial.mobiledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class DistanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        Button convertButton = (Button) findViewById(R.id.distance_convert_button);
        convertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText inches = (EditText) findViewById(R.id.inches);
                EditText feet = (EditText) findViewById(R.id.feet);
                EditText miles = (EditText) findViewById(R.id.miles);
                CheckBox metres = (CheckBox) findViewById(R.id.metres);

                if (metres.isChecked()) {
                    inches.setText((convertInches(Float.parseFloat(String.valueOf(inches.getText())))/100)+"m");
                    feet.setText((convertFeet(Float.parseFloat(String.valueOf(feet.getText())))/100)+"m");
                    miles.setText((convertMiles(Float.parseFloat(String.valueOf(miles.getText())))/100)+"m");
                }
                else {
                    inches.setText(convertInches(Float.parseFloat(String.valueOf(inches.getText())))+"cm");
                    feet.setText(convertFeet(Float.parseFloat(String.valueOf(feet.getText())))+"cm");
                    miles.setText(convertMiles(Float.parseFloat(String.valueOf(miles.getText())))+"cm");
                }

            }
        });
        restoreState(savedInstanceState);
    }

    public float convertInches(float inches) {
        return (float) (inches * 2.54);
    }

    public float convertFeet(float feet) {
        return (float) (feet * (2.545 * 12));
    }

    public float convertMiles(float miles) {
        return (float) (miles * ((2.54 * 12) * 5280));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        EditText inches = (EditText) findViewById(R.id.inches);
        EditText feet = (EditText) findViewById(R.id.feet);
        EditText miles = (EditText) findViewById(R.id.miles);
        String inputInches = inches.getText().toString();
        String inputFeet = feet.getText().toString();
        String inputMiles = miles.getText().toString();
        outState.putString("inputInches", inputInches);
        outState.putString("inputFeet", inputFeet);
        outState.putString("inputMiles", inputMiles);
        super.onSaveInstanceState(outState);
    }

    private void restoreState(Bundle state) {
        if (state == null) return;
        EditText inches = (EditText) findViewById(R.id.inches);
        EditText feet = (EditText) findViewById(R.id.feet);
        EditText miles = (EditText) findViewById(R.id.miles);
        String inputInches = state.getString("inputInches");
        String inputFeet = state.getString("inputFeet");
        String inputMiles = state.getString("inputMiles");
        inches.setText(inputInches);
        feet.setText(inputFeet);
        miles.setText(inputMiles);
    }
}
