package org.example.splitter;

import org.example.models.split.ExactSplit;
import org.example.models.split.Split;

import java.util.ArrayList;
import java.util.List;

public class EqualExpenseSplitter extends ExpenseSplitter {
    @Override
    public List<ExactSplit> normalizeToExactSplit(List<? extends Split> splits, double totalExpenseAmount) {

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
