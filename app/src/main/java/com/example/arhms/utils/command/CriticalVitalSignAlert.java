package com.example.arhms.utils.command;

import com.example.arhms.interfaces.AlertCommand;

public class CriticalVitalSignAlert implements AlertCommand {
    private AlertSystem alertSystem;

    public CriticalVitalSignAlert(AlertSystem alertSystem) {
        this.alertSystem = alertSystem;
    }

    @Override
    public void execute() {
        alertSystem.criticalVitalSignsAlert();
    }
}
