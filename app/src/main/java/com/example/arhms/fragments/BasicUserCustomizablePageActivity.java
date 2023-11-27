package com.example.arhms.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.arhms.interfaces.UserCustomizablePage;
import com.example.arhms.utils.decorator.BasicUserCustomizablePage;
import com.example.arhms.utils.decorator.HeartRateDecorator;

public class BasicUserCustomizablePageActivity extends AppCompatActivity implements UserCustomizablePage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BasicUserCustomizablePage userCustomizablePage = new BasicUserCustomizablePage(this);
        HeartRateDecorator decoratedPage = new HeartRateDecorator(this, userCustomizablePage);

        setContentView(userCustomizablePage);
    }

    @Override
    public void addView(View view) {

    }
}