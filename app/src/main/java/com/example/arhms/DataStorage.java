package com.example.arhms;

import android.app.Application;

import java.util.Random;

public class DataStorage extends Application {
    private static volatile DataStorage instance;
    private boolean heartRate = true;
    private boolean temperature = true;
    private Random random;
    private DataStorage () {
        random = new Random();
    }

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

    public int generateRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
