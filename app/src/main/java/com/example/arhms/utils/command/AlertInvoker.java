package com.example.arhms.utils.command;

import com.example.arhms.interfaces.IAlertCommand;

public class AlertInvoker {
    private IAlertCommand alertCommand;

    public void setAlertCommand(IAlertCommand alertCommand) {
        this.alertCommand = alertCommand;
    }

    public void executeAlert() {
        alertCommand.execute();
    }
}
