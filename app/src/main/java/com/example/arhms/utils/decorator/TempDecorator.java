package com.example.arhms.utils.decorator;

import android.content.Context;
import android.widget.TextView;

import com.example.arhms.abstracts.UserMetricDecorator;
import com.example.arhms.interfaces.UserCustomizablePage;

public class TempDecorator extends UserMetricDecorator {
    private UserCustomizablePage decoratedPage;

    public TempDecorator(Context context, UserCustomizablePage decoratedPage) {
        super(context);
        this.decoratedPage = decoratedPage;
        addMetric();
    }

    @Override
    public void addMetric() {
        TextView tempMetricTextView = new TextView(getContext());
        tempMetricTextView.setText("Temp Metric: Your temp value");
        decoratedPage.addView(tempMetricTextView);
    }
}
