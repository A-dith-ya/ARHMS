package com.example.arhms.interfaces;

import com.example.arhms.utils.observer.Temperature;

public interface ISubject {
    public void registerObserver(IObserver o);
    public void removeObserver(IObserver o);
    public void notifyObservers();
    public void setMeasurements(long temperature, int heartRate) ;
    public IObserver getObserver(int i);
}
