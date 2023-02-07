package org.example.splitter;

import org.example.models.split.ExactSplit;
import org.example.models.split.PercentageSplit;
import org.example.models.split.Split;

import java.util.ArrayList;
import java.util.List;

public class PercentageExpenseSplitter implements ExpenseSplitter {
    @Override
    public List<ExactSplit> toExactSplit(List<? extends Split> splits, double totalExpenseAmount) {

        validateExpenseSplit(splits, totalExpenseAmount);

        List<ExactSplit> exactSplits = new ArrayList<>();

        for (Split split : splits) {
            PercentageSplit percentageSplit = (PercentageSplit) split;
            exactSplits.add(new ExactSplit(split.getUserId(), totalExpenseAmount * percentageSplit.getPercentage() / 100));
        }

        return exactSplits;
    }

    // TODO: Implement this validation
    @Override
    public void validateExpenseSplit(List<? extends Split> splits, double totalExpenseAmount) {

    }


}