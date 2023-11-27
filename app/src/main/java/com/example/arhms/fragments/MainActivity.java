package com.example.arhms.fragments;

import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.example.arhms.R;
import com.example.arhms.interfaces.IObserver;
import com.example.arhms.interfaces.ISubject;
import com.example.arhms.utils.observer.Temperature;
import com.example.arhms.utils.observer.UserData;

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
        startActivity(new Intent(MainActivity.this, BasicUserCustomizablePageActivity.class));
    }
}