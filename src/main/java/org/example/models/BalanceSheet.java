package org.example.models;

import java.util.Map;

public class BalanceSheet {
    private String userid;

    private Map<String, Double> givenAmount;

    private Map<String, Double> owedAmount;

    public BalanceSheet(String userid, Map<String, Double> givenAmount, Map<String, Double> owedAmount) {
        this.userid = userid;
        this.givenAmount = givenAmount;
        this.owedAmount = owedAmount;
    }

    public String getUserid() {
        return userid;
    }

    public Map<String, Double> getGivenAmount() {
        return givenAmount;
    }

    public Map<String, Double> getOwedAmount() {
        return owedAmount;
    }
}