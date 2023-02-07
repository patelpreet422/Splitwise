package org.example.models.split;

public class PercentageSplit extends Split {
    private final int percentage;

    public PercentageSplit(String userId, int percentage) {
        this.userId = userId;
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }
}