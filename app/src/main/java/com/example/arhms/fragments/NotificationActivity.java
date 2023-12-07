package com.example.arhms.fragments;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.arhms.R;
import com.example.arhms.interfaces.IAlertCommand;
import com.example.arhms.utils.command.*;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Access the button by its ID
        Button hrHighBTN = findViewById(R.id.hrHigh);
        Button hrLowBTN = findViewById(R.id.hrLow);
        Button temperatureHighBTN = findViewById(R.id.temperatureHigh);
        Button temperatureLowBTN = findViewById(R.id.temperatureLow);

        AlertSystem alertSystem = new AlertSystem(this);
        AlertInvoker alertInvoker = new AlertInvoker();

        IAlertCommand heartRateHigh = new HeartRateHigh(alertSystem);
        IAlertCommand temperatureHigh = new TemperatureHigh(alertSystem);
        IAlertCommand heartRateLow = new HeartRateLow(alertSystem);
        IAlertCommand temperatureLow = new TemperatureLow(alertSystem);


        // Set a click listener for the button
        hrHighBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click event
                alertInvoker.setAlertCommand(heartRateHigh);
                heartRateHigh.execute();
            }
        });

        // Set a click listener for the button
        hrHighBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click event
                alertInvoker.setAlertCommand(heartRateLow);
                alertInvoker.executeAlert();
            }
        });

        // Set a click listener for the button
        hrLowBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click event
                alertInvoker.setAlertCommand(heartRateLow);
                alertInvoker.executeAlert();
            }
        });

        // Set a click listener for the button
        temperatureHighBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click event
                alertInvoker.setAlertCommand(temperatureHigh);
                alertInvoker.executeAlert();
            }
        });

        // Set a click listener for the button
        temperatureLowBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click event
                alertInvoker.setAlertCommand(temperatureLow);
                alertInvoker.executeAlert();
            }
        });
    }
}