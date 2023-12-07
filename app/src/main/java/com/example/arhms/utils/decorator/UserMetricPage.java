package com.example.arhms.utils.decorator;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arhms.interfaces.IUserCustomizablePage;

public class UserMetricPage extends LinearLayout implements IUserCustomizablePage {
    public UserMetricPage(Context context) {
        super(context);

        setOrientation(VERTICAL);

        TextView nameTextView = new TextView(context);
        nameTextView.setText("User Metrics");
        nameTextView.setTextColor(Color.BLACK);
        nameTextView.setTextSize(18);
        nameTextView.setPadding(50, 10, 0, 10);
        addView(nameTextView);
    }

    @Override
    public void addView(View view) {
        super.addView(view);
    }
}
