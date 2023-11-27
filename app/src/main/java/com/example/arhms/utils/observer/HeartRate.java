package com.example.arhms.utils.observer;

import com.example.arhms.interfaces.IObserver;

import java.util.ArrayList;

public class HeartRate implements IObserver {
    private ArrayList<long[]> value;

    public HeartRate() {
        this.value = new ArrayList<>();
    }

    @Override
    public void update(long temperature, long[] heartRate) {
        this.value.add(heartRate);
    }

    @Override
    public String getString() {
        return "N/A";
    }

    public ArrayList<long[]> getValue() {
        return this.value;
    }
}
