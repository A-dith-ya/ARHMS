package com.example.arhms.fragments;

import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.example.arhms.R;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
    }
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(MainActivity.this, DashboardActivity.class));
    }
}