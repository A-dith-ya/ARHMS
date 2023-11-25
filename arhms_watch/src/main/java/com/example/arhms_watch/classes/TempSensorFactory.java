package com.example.arhms_watch.classes;

import com.example.arhms_watch.interfaces.Sensor;
import com.example.arhms_watch.interfaces.SensorFactory;

public class TempSensorFactory implements SensorFactory {
    @Override
    public Sensor createSensor() {
        return new TempSensor();
    }
}
