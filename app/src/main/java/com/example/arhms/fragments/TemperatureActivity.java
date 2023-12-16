package com.example.arhms.fragments;

import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.arhms.DataStorage;
import com.example.arhms.R;
import com.example.arhms.interfaces.IObserver;
import com.example.arhms.utils.observer.UserData;

import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TemperatureActivity extends AppCompatActivity implements IObserver {
    private Handler handler;
    private TextView tempMetricTextView;
    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        DataStorage instance = DataStorage.getInstance();

        handler = new Handler();
        tempMetricTextView = findViewById(R.id.temperatureText);

        userData = new UserData();
        userData.registerObserver(this);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                userData.setMeasurements(instance.generateRandomNumber(30, 40), 0);
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }

    @Override
    protected void onDestroy() {
        // Remove the callback to prevent memory leaks
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
        userData.removeObserver(this);
    }

    @Override
    public void update(int temperature, int heartRate) {
        tempMetricTextView.setText("Temperature: " + Integer.toString(temperature) + " C");
    }

    @Override
    public String getString() {
        return null;
    }
}