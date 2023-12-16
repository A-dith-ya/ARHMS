package com.example.arhms.utils.observer;

import java.util.ArrayList;
import com.example.arhms.interfaces.IObserver;
import com.example.arhms.interfaces.ISubject;

public class UserData implements ISubject {
    private ArrayList<IObserver> observers;
    private int temperature;
    private int heartRate;

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
    public void setMeasurements(int temperature, int heartRate) {
        try {
            this.temperature = temperature;
            this.heartRate = heartRate;
            notifyObservers();
        } catch (Error error) {
            String s = error.getMessage();
        }
    }

    @Override
    public IObserver getObserver(int i) {
        return this.observers.get(i);
    }
}
