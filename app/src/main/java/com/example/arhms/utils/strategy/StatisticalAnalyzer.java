package com.example.arhms.utils.strategy;

import android.content.Context;

import com.example.arhms.interfaces.IStatistical;

public class StatisticalAnalyzer {
    IStatistical statistical;

    public StatisticalAnalyzer(IStatistical statistical) {
        this.statistical = statistical;
    }

    public void setStatistical(IStatistical statistical) {
        this.statistical = statistical;
    }

    public void compute(Context context) {
        statistical.compute(context);
    }
}
