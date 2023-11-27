package com.example.arhms.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.arhms.abstracts.UserMetricDecorator;
import com.example.arhms.interfaces.UserCustomizablePage;
import com.example.arhms.utils.decorator.BasicUserCustomizablePage;
import com.example.arhms.utils.decorator.HeartRateDecorator;
import com.example.arhms.utils.decorator.TempDecorator;

public class BasicUserCustomizablePageActivity extends AppCompatActivity implements UserCustomizablePage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BasicUserCustomizablePage userCustomizablePage = new BasicUserCustomizablePage(this);
        UserMetricDecorator heartDecoratedPage = new HeartRateDecorator(this, userCustomizablePage);
        UserMetricDecorator tempDecoratedPage = new TempDecorator(this, userCustomizablePage);

        setContentView(userCustomizablePage);
    }

    @Override
    public void addView(View view) {

    }
}