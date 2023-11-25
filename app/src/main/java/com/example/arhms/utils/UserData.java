package com.example.arhms.utils;

import java.util.ArrayList;
import com.example.arhms.interfaces.IObserver;

public class UserData {
    private ArrayList<IObserver> observers;
    private long temperature;
    private long[] heartRate = new long[2];

    public UserData () {}

    public void registerObserver(IObserver o) {
        this.observers.add(o);
    }

    public void removeObserver(IObserver o) {
        this.observers.remove(o);
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            IObserver o = (IObserver) this.observers.get(i);
            o.update(this.temperature, this.heartRate);
        }
    }

    public void setMeasurements(long temperature, long[] heartRate) {
        try {
            this.temperature = temperature;
            this.heartRate[0] = heartRate[0];
            this.heartRate[1] = heartRate[1];
            notifyObservers();
        } catch (Error error) {
            String s = error.getMessage();
        }
    }
}
