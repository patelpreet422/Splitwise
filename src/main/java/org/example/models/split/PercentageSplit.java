package org.example.models.split;

import org.example.models.split.Split;

public class PercentageSplit extends Split {
    private double percentage;

    public PercentageSplit(String userId, double percentage) {
        this.userId = userId;
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}