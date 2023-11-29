package com.example.arhms.utils.decorator;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arhms.R;
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
        LinearLayout linearLayout = new LinearLayout(getContext());

        ImageView tempImageView = new ImageView(getContext());
        tempImageView.setImageResource(R.drawable.temp_icon);
        tempImageView.setPadding(10, 10, 5, 10);

        TextView tempMetricTextView = new TextView(getContext());
        tempMetricTextView.setText("Temperature: 120 C");
        tempMetricTextView.setTextColor(Color.RED);
        tempMetricTextView.setTextSize(18);
        tempMetricTextView.setPadding(0, 10, 0, 10);

        linearLayout.addView(tempImageView);
        linearLayout.addView(tempMetricTextView);

        decoratedPage.addView(linearLayout);
    }
}
