package com.example.arhms.interfaces;

public interface ISubject {
    public void registerObserver();
    public void removeObserver();
    public void notifyObserver();
}
