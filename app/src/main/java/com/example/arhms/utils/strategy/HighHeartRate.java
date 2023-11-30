package com.example.arhms.utils.strategy;

import android.content.Context;

import com.example.arhms.interfaces.IAlertCommand;
import com.example.arhms.interfaces.IStatistical;
import com.example.arhms.utils.command.AlertInvoker;
import com.example.arhms.utils.command.AlertSystem;
import com.example.arhms.utils.command.HeartRateHigh;

public class HighHeartRate implements IStatistical {
    private double heartRate;

    public HighHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }
    @Override
    public void compute(Context context) {
        if (heartRate > 100) {
            AlertSystem alertSystem = new AlertSystem(context);
            AlertInvoker alertInvoker = new AlertInvoker();

            IAlertCommand heartRateHigh = new HeartRateHigh(alertSystem);
            alertInvoker.setAlertCommand(heartRateHigh);
            alertInvoker.executeAlert();
        }
    }
}
