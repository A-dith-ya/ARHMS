package com.example.arhms.fragments;

import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.arhms.DataStorage;
import com.example.arhms.R;
import com.example.arhms.interfaces.IObserver;
import com.example.arhms.utils.observer.UserData;

public class HeartRateActivity extends AppCompatActivity implements IObserver {
    private Handler handler;
    private TextView heartRateTextView;
    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataStorage instance = DataStorage.getInstance();
        setContentView(R.layout.activity_heart_rate);

        handler = new Handler();
        heartRateTextView = findViewById(R.id.heartRateText);

        userData = new UserData();
        userData.registerObserver(this);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                userData.setMeasurements(0, instance.generateRandomNumber(100, 160));
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userData.removeObserver(this);
    }

    @Override
    public void update(long temperature, int heartRate) {
        heartRateTextView.setText("Heart Rate: " + Integer.toString(heartRate) + " BPM");
    }

    @Override
    public String getString() {
        return null;
    }
}