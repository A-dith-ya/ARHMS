package com.example.arhms.abstracts;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.arhms.interfaces.UserCustomizablePage;

public abstract class UserMetricDecorator extends LinearLayout implements UserCustomizablePage {
    public UserMetricDecorator(Context context) {
        super(context);
    }
    abstract public void addMetric();
}
