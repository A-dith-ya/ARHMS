package com.example.arhms.utils.strategy;

import android.content.Context;

import com.example.arhms.interfaces.IAlertCommand;
import com.example.arhms.interfaces.IStatistical;
import com.example.arhms.utils.command.AlertInvoker;
import com.example.arhms.utils.command.AlertSystem;
import com.example.arhms.utils.command.TemperatureLow;

public class LowTemperature implements IStatistical {
    private double temp;

    public LowTemperature(double temp) {
        this.temp = temp;
    }

    @Override
    public void compute(Context context) {
        if (temp < 36) {
            AlertSystem alertSystem = new AlertSystem(context);
            AlertInvoker alertInvoker = new AlertInvoker();

            IAlertCommand tempLow = new TemperatureLow(alertSystem);
            alertInvoker.setAlertCommand(tempLow);
            alertInvoker.executeAlert();
        }
    }
}
