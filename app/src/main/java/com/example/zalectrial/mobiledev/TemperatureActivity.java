package com.example.zalectrial.mobiledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TemperatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        final Button convertButton = (Button) findViewById(R.id.temp_convert_button);
        convertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText celsius = (EditText) findViewById(R.id.temp_celsius);
                TextView convertedTemp = (TextView) findViewById(R.id.converted_temp);

                convertedTemp.setText(convertTemperature(String.valueOf(celsius.getText())));
            }
        });
        restoreState(savedInstanceState);
    }

    private String convertTemperature(String celsius) {

        try {
            double c = Double.parseDouble(celsius);
            double f = c * (9.0/5.0) + 32.0;
            return String.format("%3.2f", f);
        }
        catch (NumberFormatException nfe) {
            return "ERR";
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        EditText celsius = (EditText) findViewById(R.id.temp_celsius);
        String inputTemp = celsius.getText().toString();
        outState.putString("inputTemp", inputTemp);
        super.onSaveInstanceState(outState);
    }

    private void restoreState(Bundle state) {
        if (state == null) return;
        EditText celsius = (EditText) findViewById(R.id.temp_celsius);
        String inputTemp = state.getString("inputTemp");
        celsius.setText(inputTemp);
    }
}
