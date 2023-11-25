package com.example.arhms.utils.observer;

import java.util.ArrayList;
import com.example.arhms.interfaces.IObserver;
import com.example.arhms.interfaces.ISubject;

public class UserData implements ISubject {
    private ArrayList<IObserver> observers;
    private long temperature;
    private long[] heartRate = new long[2];

    public UserData () {
        this.observers = new ArrayList<IObserver>(2);
        registerObserver(new Temperature());
        registerObserver(new HeartRate());
    }

    @Override
    public void registerObserver(IObserver o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            IObserver o = (IObserver) this.observers.get(i);
            o.update(this.temperature, this.heartRate);
        }
    }

    @Override
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
