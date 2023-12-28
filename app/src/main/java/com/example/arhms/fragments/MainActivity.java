package com.example.arhms.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arhms.R;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewForNavigation = findViewById(R.id.userMetrics);
        setTextViewClickListener(textViewForNavigation, UserCustomizableActivity.class);

        TextView textViewForNavigation2 = findViewById(R.id.settings);
        setTextViewClickListener(textViewForNavigation2, MetricManagementActivity.class);

        TextView textViewForNavigation3 = findViewById(R.id.heartRateMonitor);
        setTextViewClickListener(textViewForNavigation3, HeartRateActivity.class);

        TextView textViewForNavigation4 = findViewById(R.id.temperatureMonitor);
        setTextViewClickListener(textViewForNavigation4, TemperatureActivity.class);

        TextView textViewForNavigation5 = findViewById(R.id.notifications);
        setTextViewClickListener(textViewForNavigation5, NotificationActivity.class);

        TextView textViewForNavigation6 = findViewById(R.id.rexRunGame);
        setTextViewClickListener(textViewForNavigation6, RexRunActivity.class);
    }

    private void setTextViewClickListener(TextView textView, final Class<?> targetActivityClass) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, targetActivityClass));
            }
        });
    }
}