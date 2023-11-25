package com.example.arhms.utils.command;

import com.example.arhms.interfaces.AlertCommand;

public class AlertInvoker {
    private AlertCommand alertCommand;

    public void setAlertCommand(AlertCommand alertCommand) {
        this.alertCommand = alertCommand;
    }

    public void executeAlert() {
        alertCommand.execute();
    }
}
