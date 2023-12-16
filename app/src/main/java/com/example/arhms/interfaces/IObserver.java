package com.example.arhms.interfaces;

public interface IObserver {
    public void update(long temperature, int heartRate);
    public String getString();
}
