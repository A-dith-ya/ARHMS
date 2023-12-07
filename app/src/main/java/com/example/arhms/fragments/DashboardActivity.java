package com.example.arhms.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.arhms.R;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView textViewForNavigation = findViewById(R.id.textView);
        setTextViewClickListener(textViewForNavigation, BasicUserCustomizablePageActivity.class);

        TextView textViewForNavigation2 = findViewById(R.id.textView2);
        setTextViewClickListener(textViewForNavigation2, MetricManagementActivity.class);

        TextView textViewForNavigation3 = findViewById(R.id.textView3);
        setTextViewClickListener(textViewForNavigation3, HeartRateActivity.class);

        TextView textViewForNavigation4 = findViewById(R.id.textView4);
        setTextViewClickListener(textViewForNavigation4, TemperatureActivity.class);

        TextView textViewForNavigation5 = findViewById(R.id.textView5);
        setTextViewClickListener(textViewForNavigation5, NotificationActivity.class);
    }

    private void setTextViewClickListener(TextView textView, final Class<?> targetActivityClass) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, targetActivityClass));
            }
        });
    }
}