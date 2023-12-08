package com.example.arhms.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.example.arhms.DataStorage;
import com.example.arhms.R;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MetricManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metric_management);

        TextView heartRateTextView = findViewById(R.id.heartRateWidget);
        setHeartRateTextViewClick(heartRateTextView);

        TextView temperatureTextView = findViewById(R.id.temperatureWidget);
        setTemperatureTextViewClick(temperatureTextView);
    }

    private void setHeartRateTextViewClick(TextView textView) {
        DataStorage instance = DataStorage.getInstance();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instance.toggleHeartRate();
                System.out.println("============== Temperature Click ==============");
                System.out.println(instance.getHeartRate());
                System.out.println(instance.getTemperature());
            }
        });
    }

    private void setTemperatureTextViewClick(TextView textView) {
        DataStorage instance = DataStorage.getInstance();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instance.toggleTemperature();
                System.out.println("============== Temperature Click ==============");
                System.out.println(instance.getHeartRate());
                System.out.println(instance.getTemperature());
            }
        });
    }
}