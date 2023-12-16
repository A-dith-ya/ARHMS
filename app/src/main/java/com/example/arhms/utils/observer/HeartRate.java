package com.example.arhms.utils.observer;

import com.example.arhms.interfaces.IObserver;

import java.util.ArrayList;

public class HeartRate implements IObserver {
    private int value;

    public HeartRate() {}

    @Override
    public void update(int temperature, int heartRate) {
        this.value = heartRate;
    }

    @Override
    public String getString() {
        return "N/A";
    }

    public long getValue() {
        return this.value;
    }
}
