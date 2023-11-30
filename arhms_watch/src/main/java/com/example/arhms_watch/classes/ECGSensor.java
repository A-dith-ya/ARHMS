package com.example.arhms_watch.classes;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.example.arhms_watch.interfaces.Sensor;

import java.util.Random;

public class ECGSensor implements Sensor {
    private int heartRate;
    @Override
    public void measure() {
        Random random = new Random();
        this.heartRate = random.nextInt(41) + 60;
    }

    public String getValue() {
        return ("ECG: " + String.valueOf(this.heartRate));
    }
}
