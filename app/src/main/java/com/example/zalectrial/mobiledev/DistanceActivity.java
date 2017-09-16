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

        // Add onClickListener to the distance convert button
        Button convertButton = (Button) findViewById(R.id.distance_convert_button);
        convertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText inches = (EditText) findViewById(R.id.inches);
                EditText feet = (EditText) findViewById(R.id.feet);
                EditText miles = (EditText) findViewById(R.id.miles);
                CheckBox metres = (CheckBox) findViewById(R.id.metres);

                // Convert the distances and set the fields
                if (metres.isChecked()) {
                    inches.setText((convertInches(Float.parseFloat(String.valueOf(inches.getText())))/100)+"m");
                    feet.setText((convertFeet(Float.parseFloat(String.valueOf(feet.getText())))/100)+"m");
                    miles.setText((convertMiles(Float.parseFloat(String.valueOf(miles.getText())))/100)+"m");
                }
                else {
                    inches.setText(convertInches(Float.parseFloat(String.valueOf(inches.getText())))*10+"mm");
                    feet.setText(convertFeet(Float.parseFloat(String.valueOf(feet.getText())))*10+"mm");
                    miles.setText(convertMiles(Float.parseFloat(String.valueOf(miles.getText())))*10+"mm");
                }

            }
        });
        restoreState(savedInstanceState);
    }

    // Convert inches to cm
    public float convertInches(float inches) {
        return (float) (inches * 2.54);
    }

    // Convert feet to cm
    public float convertFeet(float feet) {
        return (float) (feet * (2.545 * 12));
    }

    // Convert miles to cm
    public float convertMiles(float miles) {
        return (float) (miles * ((2.54 * 12) * 5280));
    }

    // Save the field values when saving instance state
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

    // Restore the saved field values
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
