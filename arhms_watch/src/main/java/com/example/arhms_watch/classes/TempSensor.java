package com.example.arhms_watch.classes;

import com.example.arhms_watch.interfaces.Sensor;

import java.text.DecimalFormat;
import java.util.Random;

public class TempSensor implements Sensor {
    private static final double MIN_TEMPERATURE = 36.4;
    private static final double MAX_TEMPERATURE = 37.2;
    private double value;

    @Override
    public void measure() {
        Random random = new Random();
        this.value = MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * random.nextDouble();
    }

    public String getValue() {
        String pattern = "#." + new String(new char[2]).replace("\0", "0");
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return ("T: " + String.valueOf(decimalFormat.format(this.value)) + " C");
    }
}
