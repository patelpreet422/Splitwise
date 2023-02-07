package org.example.splitter;

import org.example.exceptions.ExpenseSplitValidationException;
import org.example.models.split.ExactSplit;
import org.example.models.split.PercentageSplit;
import org.example.models.split.Split;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PercentageExpenseSplitter extends ExpenseSplitter {
    @Override
    public List<ExactSplit> normalizeToExactSplit(List<? extends Split> splits, double totalExpenseAmount) {

        List<ExactSplit> exactSplits = new ArrayList<>();

        for (Split split : splits) {
            PercentageSplit percentageSplit = (PercentageSplit) split;
            exactSplits.add(new ExactSplit(split.getUserId(), totalExpenseAmount * percentageSplit.getPercentage() / 100));
        }

        return exactSplits;
    }

    @Override
    public void validateExpenseSplit(List<? extends Split> splits, double totalExpenseAmount) {
        int totalPercentage = 100;

        int actualPercentageSum = splits
                .stream()
                .mapToInt(split -> ((PercentageSplit)split).getPercentage())
                .sum();

        if(actualPercentageSum != totalPercentage) {
            throw new ExpenseSplitValidationException(
                    "Sum of all percentageContribution for given expense splits != 100, percentage splits found: " +
                            Arrays.toString(splits.stream().mapToInt(split -> ((PercentageSplit) split).getPercentage()).toArray()),
                    null
            );
        }
    }


}