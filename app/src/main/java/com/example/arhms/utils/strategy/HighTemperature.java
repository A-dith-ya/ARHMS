package com.example.arhms.utils.strategy;

import android.content.Context;

import com.example.arhms.interfaces.IAlertCommand;
import com.example.arhms.interfaces.IStatistical;
import com.example.arhms.utils.command.AlertInvoker;
import com.example.arhms.utils.command.AlertSystem;
import com.example.arhms.utils.command.TemperatureHigh;

public class HighTemperature implements IStatistical {
    private double temp;

    public HighTemperature(double temp) {
        this.temp = temp;
    }

    @Override
    public void compute(Context context) {
        if (temp > 37.5) {
            AlertSystem alertSystem = new AlertSystem(context);
            AlertInvoker alertInvoker = new AlertInvoker();

            IAlertCommand tempHigh = new TemperatureHigh(alertSystem);
            alertInvoker.setAlertCommand(tempHigh);
            alertInvoker.executeAlert();
        }
    }
}
