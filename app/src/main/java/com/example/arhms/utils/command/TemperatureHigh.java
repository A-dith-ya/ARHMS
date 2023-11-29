package com.example.arhms.utils.command;

import com.example.arhms.interfaces.IAlertCommand;

public class TemperatureHigh implements IAlertCommand {
    private AlertSystem alertSystem;

    public TemperatureHigh(AlertSystem alertSystem) {
        this.alertSystem = alertSystem;
    }
    @Override
    public void execute() {
        alertSystem.temperatureHigh();
    }
}
