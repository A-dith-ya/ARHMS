package com.example.arhms.fragments;

import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.arhms.DataStorage;
import com.example.arhms.R;

import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TemperatureActivity extends AppCompatActivity {
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        DataStorage instance = DataStorage.getInstance();

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView tempMetricTextView = findViewById(R.id.temperatureText);

                tempMetricTextView.setText("Temperature: " + Integer.toString(instance.generateRandomNumber(30, 40)) + " C");
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }

    @Override
    protected void onDestroy() {
        // Remove the callback to prevent memory leaks
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}