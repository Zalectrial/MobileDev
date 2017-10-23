package com.example.zalectrial.mobiledev.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import  com.example.zalectrial.mobiledev.R;
import  com.example.zalectrial.mobiledev.calc.AstronomicalCalendar;
import  com.example.zalectrial.mobiledev.calc.GeoLocation;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Spinner;
import android.widget.TextView;

public class Main extends Activity 
{

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeUI();
    }

	private void initializeUI()
	{
        Spinner locationSpinner = (Spinner) findViewById(R.id.locationSpinner);
        String[] locations;
        try {
            locations = readLocations();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locations);
            locationSpinner.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }

		DatePicker dp = (DatePicker) findViewById(R.id.datePicker);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		dp.init(year,month,day,dateChangeHandler); // setup initial values and reg. handler
		updateTime(year, month, day);
	}
    
	private void updateTime(int year, int monthOfYear, int dayOfMonth)
	{
		TimeZone tz = TimeZone.getDefault();
		GeoLocation geolocation = new GeoLocation("Melbourne", -37.50, 145.01, tz);
		AstronomicalCalendar ac = new AstronomicalCalendar(geolocation);
		ac.getCalendar().set(year, monthOfYear, dayOfMonth);
		Date srise = ac.getSunrise();
		Date sset = ac.getSunset();
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		TextView sunriseTV = (TextView) findViewById(R.id.sunriseTimeTV);
		TextView sunsetTV = (TextView) findViewById(R.id.sunsetTimeTV);
		Log.d("SUNRISE Unformatted", srise+"");
		
		sunriseTV.setText(sdf.format(srise));
		sunsetTV.setText(sdf.format(sset));		
	}
	
	OnDateChangedListener dateChangeHandler = new OnDateChangedListener()
	{
		public void onDateChanged(DatePicker dp, int year, int monthOfYear, int dayOfMonth)
		{
			updateTime(year, monthOfYear, dayOfMonth);
		}	
	};

	private String[] readLocations() throws IOException {
        String[] locations;

        AssetManager assetManager = this.getAssets();
        InputStream inputStream = assetManager.open("Locations");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ArrayList<GeoLocation> temp = new ArrayList<>();

        String line = bufferedReader.readLine();
        while (line != null) {
            String[] splitLine = line.split(",");
            GeoLocation location = new GeoLocation(splitLine[0], Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]), TimeZone.getTimeZone(splitLine[3]));
            temp.add(location);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        locations = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            locations[i] = temp.get(i).getLocationName();
        }

        return locations;
    }
	
}