package com.example.arhms.utils.decorator;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arhms.interfaces.UserCustomizablePage;

public class BasicUserCustomizablePage extends LinearLayout implements UserCustomizablePage {
    public BasicUserCustomizablePage(Context context) {
        super(context);

        setOrientation(VERTICAL);

        TextView nameTextView = new TextView(context);
        nameTextView.setText("User Metrics Dashboard");
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
