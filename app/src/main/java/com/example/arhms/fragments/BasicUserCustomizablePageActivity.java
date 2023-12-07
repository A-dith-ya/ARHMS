package com.example.arhms.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.arhms.abstracts.UserMetricDecorator;
import com.example.arhms.interfaces.IUserCustomizablePage;
import com.example.arhms.utils.decorator.UserMetricPage;
import com.example.arhms.utils.decorator.HeartRateDecorator;
import com.example.arhms.utils.decorator.TempDecorator;

public class BasicUserCustomizablePageActivity extends AppCompatActivity implements IUserCustomizablePage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserMetricPage userCustomizablePage = new UserMetricPage(this);
        UserMetricDecorator heartDecoratedPage = new HeartRateDecorator(this, userCustomizablePage);
        UserMetricDecorator tempDecoratedPage = new TempDecorator(this, userCustomizablePage);

        setContentView(userCustomizablePage);
    }

    @Override
    public void addView(View view) {

    }
}