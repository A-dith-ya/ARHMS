package com.example.arhms_watch.classes;

import com.example.arhms_watch.interfaces.Sensor;

import java.util.Random;

public class TempSensor implements Sensor {
    private static final double MIN_TEMPERATURE = 36.4;
    private static final double MAX_TEMPERATURE = 37.2;

    @Override
    public void measure() {
        Random random = new Random();
        double temp = MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * random.nextDouble();
    }
}
