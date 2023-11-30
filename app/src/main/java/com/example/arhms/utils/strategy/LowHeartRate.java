package com.example.arhms.utils.strategy;

import android.content.Context;

import com.example.arhms.interfaces.IAlertCommand;
import com.example.arhms.interfaces.IStatistical;
import com.example.arhms.utils.command.AlertInvoker;
import com.example.arhms.utils.command.AlertSystem;
import com.example.arhms.utils.command.HeartRateLow;

public class LowHeartRate implements IStatistical {
    private double heartRate;

    public LowHeartRate(double heartRate) {
        this.heartRate=heartRate;
    }
    @Override
    public void compute(Context context) {
        if (heartRate < 60) {
            AlertSystem alertSystem = new AlertSystem(context);
            AlertInvoker alertInvoker = new AlertInvoker();

            IAlertCommand heartRateLow = new HeartRateLow(alertSystem);
            alertInvoker.setAlertCommand(heartRateLow);
            alertInvoker.executeAlert();
        }
    }
}
