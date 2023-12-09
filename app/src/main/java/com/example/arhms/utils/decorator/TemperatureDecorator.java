package com.example.arhms.utils.decorator;

import android.os.Handler;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arhms.DataStorage;
import com.example.arhms.R;
import com.example.arhms.abstracts.UserMetricDecorator;
import com.example.arhms.interfaces.IUserCustomizablePage;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TemperatureDecorator extends UserMetricDecorator {
    private IUserCustomizablePage decoratedPage;

    public TemperatureDecorator(Context context, IUserCustomizablePage decoratedPage) {
        super(context);
        this.decoratedPage = decoratedPage;
        addMetric();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void addMetric() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        DataStorage instance = DataStorage.getInstance();

        ImageView tempImageView = new ImageView(getContext());
        tempImageView.setImageResource(R.drawable.temp_icon);
        tempImageView.setPadding(10, 10, 5, 10);

        TextView tempMetricTextView = new TextView(getContext());

        tempMetricTextView.setText("Temperature: " + Integer.toString(instance.generateRandomNumber(30,40)) + " C");
        tempMetricTextView.setTextColor(Color.RED);
        tempMetricTextView.setTextSize(18);
        tempMetricTextView.setPadding(0, 10, 0, 10);

        linearLayout.addView(tempImageView);
        linearLayout.addView(tempMetricTextView);

        decoratedPage.addView(linearLayout);
    }
}
