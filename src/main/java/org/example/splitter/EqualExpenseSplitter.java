package org.example.splitter;

import org.example.models.split.ExactSplit;
import org.example.models.split.Split;

import java.util.ArrayList;
import java.util.List;

public class EqualExpenseSplitter implements ExpenseSplitter {
    @Override
    public List<ExactSplit> toExactSplit(List<? extends Split> splits, double totalExpenseAmount) {
        validateExpenseSplit(splits, totalExpenseAmount);

        if(splits.size() == 0) {
            return new ArrayList<>();
        }

        double equalShare = totalExpenseAmount/splits.size();
        List<ExactSplit> exactSplits = new ArrayList<>();

        for (Split split : splits) {
            exactSplits.add(new ExactSplit(split.getUserId(), equalShare));
        }

        return exactSplits;
    }

    // TODO: Implement this validation
    @Override
    public void validateExpenseSplit(List<? extends Split> splits, double totalExpenseAmount) {

    }
}
