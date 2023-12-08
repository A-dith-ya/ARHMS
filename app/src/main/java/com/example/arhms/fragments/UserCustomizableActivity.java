package com.example.arhms.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.arhms.DataStorage;
import com.example.arhms.abstracts.UserMetricDecorator;
import com.example.arhms.interfaces.IUserCustomizablePage;
import com.example.arhms.utils.decorator.UserMetricPage;
import com.example.arhms.utils.decorator.HeartRateDecorator;
import com.example.arhms.utils.decorator.TemperatureDecorator;

public class UserCustomizableActivity extends AppCompatActivity implements IUserCustomizablePage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataStorage instance = DataStorage.getInstance();
        UserMetricDecorator heartRateDecorator;
        UserMetricDecorator temperatureDecorator;

        UserMetricPage userMetricPage = new UserMetricPage(this);
        if (instance.getHeartRate())
            heartRateDecorator = new HeartRateDecorator(this, userMetricPage);
        if (instance.getTemperature())
            temperatureDecorator = new TemperatureDecorator(this, userMetricPage);

        setContentView(userMetricPage);
    }

    @Override
    public void addView(View view) {

    }
}