package com.example.arhms.utils.observer;

import com.example.arhms.interfaces.IObserver;

public class Temperature implements IObserver {
    private long value;

    @Override
    public void update(long temperature, long[] heartRate) {
        this.value = temperature;
        // do nothing with heart rate
    }

    public String getString() {
        return String.valueOf(this.value);
    }
}
