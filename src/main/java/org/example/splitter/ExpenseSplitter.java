package org.example.splitter;

import org.example.models.split.ExactSplit;
import org.example.models.split.Split;

import java.util.List;

public abstract class ExpenseSplitter {
    public final List<ExactSplit> toExactSplit(List<? extends Split> splits, double totalExpenseAmount) {
        validateExpenseSplit(splits, totalExpenseAmount);
        return normalizeToExactSplit(splits, totalExpenseAmount);
    }

    protected abstract List<ExactSplit> normalizeToExactSplit(List<? extends Split> splits, double totalExpenseAmount);

    protected abstract void validateExpenseSplit(List<? extends Split> splits, double totalExpenseAmount);
}