package com.example.arhms.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.example.arhms.DataStorage;
import com.example.arhms.R;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MetricManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataStorage instance = DataStorage.getInstance();
        setContentView(R.layout.activity_metric_management);

        ToggleButton heartRateToggle = findViewById(R.id.toggleHeartRate);
        heartRateToggle.setChecked(instance.getHeartRate());
        heartRateToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                instance.toggleHeartRate();
                System.out.println("============== HeartRate Toggle ==============");
                System.out.println(instance.getHeartRate());
                System.out.println(instance.getTemperature());
            }
        });

        ToggleButton temperatureToggle = findViewById(R.id.toggleTemperature);
        temperatureToggle.setChecked(instance.getTemperature());
        temperatureToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                instance.toggleTemperature();
                System.out.println("============== Temperature Toggle ==============");
                System.out.println(instance.getHeartRate());
                System.out.println(instance.getTemperature());
            }
        });
    }
}