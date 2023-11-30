package com.example.arhms_watch.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.arhms_watch.R;
import com.example.arhms_watch.classes.ECGSensorFactory;
import com.example.arhms_watch.classes.TempSensorFactory;
import com.example.arhms_watch.databinding.ActivityMainBinding;
import com.example.arhms_watch.interfaces.Sensor;
import com.example.arhms_watch.interfaces.SensorFactory;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Access the TextView and set its text
        TextView textView = findViewById(R.id.textView);
        textView.setText("Health Monitor");

        SensorFactory factory = new TempSensorFactory();
        Sensor temperature = factory.createSensor();
        temperature.measure();

        TextView temperatureTextView = findViewById(R.id.temperatureTextView);
        temperatureTextView.setText(temperature.getValue());

        factory = new ECGSensorFactory();
        Sensor ecg = factory.createSensor();
        ecg.measure();

        TextView ecgTextView = findViewById(R.id.ecgTextView);
        ecgTextView.setText(ecg.getValue());
    }
}
