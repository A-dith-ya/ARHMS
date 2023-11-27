package com.example.arhms.utils.command;

import com.example.arhms.interfaces.AlertCommand;

public class HeartRateAlert implements AlertCommand {
    private AlertSystem alertSystem;

    public HeartRateAlert(AlertSystem alertSystem) {
        this.alertSystem = alertSystem;
    }

    @Override
    public void execute() {
        alertSystem.heartRateAlert();
    }
}
