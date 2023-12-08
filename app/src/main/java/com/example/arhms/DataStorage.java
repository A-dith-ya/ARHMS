package com.example.arhms;

import android.app.Application;

public class DataStorage extends Application {
    private static volatile DataStorage instance;
    private boolean heartRate = false;
    private boolean temperature = false;
    private DataStorage () {}

    public static DataStorage getInstance () {
        if (instance == null) {
            synchronized (DataStorage.class) {
                if (instance == null) {
                    instance = new DataStorage();
                }
            }
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
