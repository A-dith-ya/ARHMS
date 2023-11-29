package com.example.arhms.utils.command;

import com.example.arhms.interfaces.IAlertCommand;

public class HeartRateHigh implements IAlertCommand {
    private AlertSystem alertSystem;

    public HeartRateHigh(AlertSystem alertSystem) {
        this.alertSystem = alertSystem;
    }

    @Override
    public void execute() {
        alertSystem.heartRateHigh();
    }
}
