package com.example.arhms;

import android.app.Application;

public class DataStorage extends Application {
    private static DataStorage instance;
    private boolean heartRate = false;
    private boolean temperature = false;
    private DataStorage () {
        instance.getInstance();
    }

    public static DataStorage getInstance () {
        if (instance == null) {
            instance = new DataStorage();
        }
        return instance;
    }

    public Boolean getHeartRate() {
        return heartRate;
    }

    public Boolean getTemperature() {
        return temperature;
    }

    public void toggleHeartRate() {
        this.heartRate = !this.heartRate;
    }

    public void toggleTemperature() {
        this.temperature = !this.temperature;
    }
}
