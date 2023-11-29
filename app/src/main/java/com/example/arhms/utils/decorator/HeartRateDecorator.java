package com.example.arhms.utils.decorator;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arhms.abstracts.UserMetricDecorator;
import com.example.arhms.interfaces.UserCustomizablePage;
import com.example.arhms.R;

public class HeartRateDecorator extends UserMetricDecorator {
    private UserCustomizablePage decoratedPage;

    public HeartRateDecorator(Context context, UserCustomizablePage decoratedPage) {
        super(context);
        this.decoratedPage = decoratedPage;
        addMetric();
    }

    @Override
    public void addMetric() {
        LinearLayout linearLayout = new LinearLayout(getContext());

        ImageView heartImageView = new ImageView(getContext());
        heartImageView.setImageResource(R.drawable.heart_icon);
        heartImageView.setPadding(10, 10, 5, 10);

        TextView heartRateMetricTextView = new TextView(getContext());
        heartRateMetricTextView.setText("Abnormal Heart Rate: 120 bpm");
        heartRateMetricTextView.setTextColor(Color.RED);
        heartRateMetricTextView.setTextSize(18);
        heartRateMetricTextView.setPadding(0, 10, 0, 10);

        linearLayout.addView(heartImageView);
        linearLayout.addView(heartRateMetricTextView);

        decoratedPage.addView(linearLayout);
    }
}
