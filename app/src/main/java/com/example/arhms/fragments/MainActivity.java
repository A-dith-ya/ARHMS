package com.example.arhms.fragments;

import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.arhms.R;
import com.example.arhms.interfaces.IObserver;
import com.example.arhms.interfaces.ISubject;
import com.example.arhms.utils.observer.Temperature;
import com.example.arhms.utils.observer.UserData;
import com.example.arhms.interfaces.AlertCommand;
import com.example.arhms.utils.command.AlertInvoker;
import com.example.arhms.utils.command.AlertSystem;
import com.example.arhms.utils.command.CriticalVitalSignAlert;
import com.example.arhms.utils.command.HeartRateAlert;
import com.example.arhms.utils.command.TempAlert;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ISubject subject = new UserData();
        subject.setMeasurements(35,new long[]{120, 60});
        subject.setMeasurements(36,new long[]{125, 60});
        subject.setMeasurements(34,new long[]{130, 60});

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editTextExample);

        String s = subject.getObserver(0).getString();

        editText.setText(s);
        AlertSystem alertSystem = new AlertSystem(this);
        AlertInvoker alertInvoker = new AlertInvoker();

        AlertCommand criticalVitalSignAlert = new CriticalVitalSignAlert(alertSystem);
        AlertCommand heartRateAlert = new HeartRateAlert(alertSystem);
        AlertCommand tempAlert = new TempAlert(alertSystem);

        alertInvoker.setAlertCommand(criticalVitalSignAlert);
        alertInvoker.executeAlert();

        alertInvoker.setAlertCommand(heartRateAlert);
        alertInvoker.executeAlert();

        alertInvoker.setAlertCommand(tempAlert);
        alertInvoker.executeAlert();
    }
}