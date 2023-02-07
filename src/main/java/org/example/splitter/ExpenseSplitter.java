package org.example.splitter;

import org.example.models.split.ExactSplit;
import org.example.models.split.Split;

import java.util.List;

public interface ExpenseSplitter {
    List<ExactSplit> toExactSplit(List<? extends Split> splits, double totalExpenseAmount);

    void validateExpenseSplit(List<? extends Split> splits, double totalExpenseAmount);
}