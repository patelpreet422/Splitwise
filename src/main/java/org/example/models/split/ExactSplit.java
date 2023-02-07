package org.example.models.split;

public class ExactSplit extends Split {
    private double amountShare;

    public ExactSplit(String userId, double amountShare) {
        super();
        this.userId = userId;
        this.amountShare = amountShare;
    }

    public double getAmountShare() {
        return amountShare;
    }
}