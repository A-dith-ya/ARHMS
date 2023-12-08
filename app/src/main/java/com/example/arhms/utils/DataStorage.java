package com.example.arhms.utils;

import android.app.Application;

public class DataStorage extends Application {
    private DataStorage instance;
    private boolean heartRate = false;
    private boolean temperature = false;
    private DataStorage () {

    }

    public DataStorage getInstance () {
        if (this.instance == null) {
            this.instance = new DataStorage();
        }
        return this.instance;
    }

    public String getHeartRate() {
        return Boolean.toString(this.heartRate);
    }

    public String getTemperature() {
        return Boolean.toString(this.temperature);
    }

    public void toggleHeartRate() {
        this.heartRate = !this.heartRate;
    }

    public void toggleTemperature() {
        this.temperature = !this.temperature;
    }
}
