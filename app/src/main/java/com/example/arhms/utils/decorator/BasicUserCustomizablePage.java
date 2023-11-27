package com.example.arhms.utils.decorator;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arhms.interfaces.UserCustomizablePage;

public class BasicUserCustomizablePage extends LinearLayout implements UserCustomizablePage {
    public BasicUserCustomizablePage(Context context) {
        super(context);

        setOrientation(VERTICAL);

        TextView nameTextView = new TextView(context);
        nameTextView.setText("Basic Page");
        addView(nameTextView);
    }

    @Override
    public void addView(View view) {
        super.addView(view);
    }
}
