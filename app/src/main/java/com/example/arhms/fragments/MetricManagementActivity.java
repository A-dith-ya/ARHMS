package com.example.arhms.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.example.arhms.DataStorage;
import com.example.arhms.R;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MetricManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metric_management);

        TextView textViewForNavigation = findViewById(R.id.heartRateWidget);
        setTextViewClickListener(textViewForNavigation, BasicUserCustomizablePageActivity.class);
    }

    private void setTextViewClickListener(TextView textView, final Class<?> targetActivityClass) {
        DataStorage instance = DataStorage.getInstance();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instance.toggleHeartRate();
                System.out.print("============================");
                System.out.println(instance.getHeartRate());
            }
        });
    }
}