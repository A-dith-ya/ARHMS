package com.example.arhms.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.arhms.R;
import com.example.arhms.interfaces.ISubject;
import com.example.arhms.utils.observer.UserData;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
        ISubject s = new UserData();
        s.setMeasurements(35,new long[]{120, 60});
        s.setMeasurements(36,new long[]{125, 60});
        s.setMeasurements(34,new long[]{130, 60});
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}