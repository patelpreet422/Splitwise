package org.example.models.expense;

import org.example.models.split.ExpenseSplitType;
import org.example.models.split.Split;

import java.util.List;

public class Expense {
    private String expenseId;

    private double totalExpenseAmount;

    private String description;

    private List<? extends Split> splits;

    private ExpenseSplitType splitType;

    private String paidUserId;

    public Expense(String expenseId, double totalExpenseAmount, String description, List<? extends Split> splits, ExpenseSplitType splitType, String paidUserId) {
        this.expenseId = expenseId;
        this.totalExpenseAmount = totalExpenseAmount;
        this.description = description;
        this.splits = splits;
        this.splitType = splitType;
        this.paidUserId = paidUserId;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getPaidUserId() {
        return paidUserId;
    }

    public double getTotalExpenseAmount() {
        return totalExpenseAmount;
    }

    public String getDescription() {
        return description;
    }

    public List<? extends Split> getSplits() {
        return splits;
    }

    public ExpenseSplitType getSplitType() {
        return splitType;
    }
}
