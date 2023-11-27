package com.example.arhms.utils.command;

import com.example.arhms.interfaces.AlertCommand;

public class TempAlert implements AlertCommand {
    private AlertSystem alertSystem;

    public TempAlert(AlertSystem alertSystem) {
        this.alertSystem = alertSystem;
    }

    @Override
    public void execute() {
        alertSystem.temperatureAlert();
    }
}
