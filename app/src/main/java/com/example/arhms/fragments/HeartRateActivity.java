package com.example.arhms.fragments;

import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.arhms.DataStorage;
import com.example.arhms.R;

public class HeartRateActivity extends AppCompatActivity {
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataStorage instance = DataStorage.getInstance();
        setContentView(R.layout.activity_heart_rate);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView tempMetricTextView = findViewById(R.id.heartRateText);

                tempMetricTextView.setText("Heart Rate: " + Integer.toString(instance.generateRandomNumber(100, 160)) + " BPM");
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }
}