package com.example.arhms.utils.command;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.arhms.interfaces.IAlertCommand;

public class AlertSystem {
    private Context context;

    public AlertSystem(Context context) {
        this.context = context;
    }

    public void heartRateLow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Heart Rate Alert")
                .setMessage("Your heart rate signs are abnormally low.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public void heartRateHigh() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Heart Rate Alert")
                .setMessage("Your heart rate signs are abnormally high.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public void temperatureLow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Temperature Alert")
                .setMessage("Your temperature is abnormally low.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public void temperatureHigh() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Temperature Alert")
                .setMessage("Your temperature is abnormally high.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
