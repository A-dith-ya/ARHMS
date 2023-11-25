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
    public void criticalVitalSignsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Critical Vital Signs Alert")
                .setMessage("Your critical signs are extreme.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
