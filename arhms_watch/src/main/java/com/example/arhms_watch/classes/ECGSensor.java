package com.example.arhms_watch.classes;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.example.arhms_watch.interfaces.Sensor;

import java.util.Random;

public class ECGSensor implements Sensor {
    @Override
    public void measure() {
        Random random = new Random();
        int heartRate = random.nextInt(41) + 60;
    }
}
