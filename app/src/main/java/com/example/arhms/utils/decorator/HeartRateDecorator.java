package com.example.arhms.utils.decorator;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.arhms.abstracts.UserMetricDecorator;
import com.example.arhms.interfaces.UserCustomizablePage;

public class HeartRateDecorator extends UserMetricDecorator {
    private UserCustomizablePage decoratedPage;

    public HeartRateDecorator(Context context, UserCustomizablePage decoratedPage) {
        super(context);
        this.decoratedPage = decoratedPage;
        addMetric();
    }

    @Override
    public void addMetric() {
        TextView heartRateMetricTextView = new TextView(getContext());
        heartRateMetricTextView.setText("Heart Metric: Your heart rate value");
        decoratedPage.addView(heartRateMetricTextView);
    }
}
