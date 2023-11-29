package com.example.arhms.utils.command;

import com.example.arhms.interfaces.IAlertCommand;

public class HeartRateLow implements IAlertCommand {
    private AlertSystem alertSystem;

    public HeartRateLow (AlertSystem alertSystem) {
        this.alertSystem = alertSystem;
    }

    @Override
    public void execute() {
        alertSystem.heartRateLow();
    }
}
