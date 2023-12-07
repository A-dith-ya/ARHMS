package com.example.arhms.abstracts;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.arhms.interfaces.IUserCustomizablePage;

public abstract class UserMetricDecorator extends LinearLayout implements IUserCustomizablePage {
    public UserMetricDecorator(Context context) {
        super(context);
    }
    abstract public void addMetric();
}
