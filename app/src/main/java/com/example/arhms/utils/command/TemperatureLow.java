package com.example.arhms.utils.command;

import com.example.arhms.interfaces.IAlertCommand;

public class TemperatureLow implements IAlertCommand {
    private AlertSystem alertSystem;

    public TemperatureLow(AlertSystem alertSystem) {
        this.alertSystem = alertSystem;
    }

    @Override
    public void execute() {
        alertSystem.temperatureAlert();
    }
}
