package org.example.splitter;

import org.example.exceptions.ExpenseSplitValidationException;
import org.example.models.split.ExactSplit;
import org.example.models.split.Split;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExactExpenseSplitter extends ExpenseSplitter {
    @Override
    public List<ExactSplit> normalizeToExactSplit(List<? extends Split> splits, double totalExpenseAmount) {

        List<ExactSplit> exactSplits = new ArrayList<>();
        for(Split split: splits) {
            ExactSplit exactSplit = (ExactSplit) split;
            exactSplits.add(exactSplit);
        }
        return exactSplits;
    }

    // TODO: Implement this validation
    @Override
    public void validateExpenseSplit(List<? extends Split> splits, double totalExpenseAmount) {
        double splitContributionSum = splits.stream()
                .mapToDouble(split -> ((ExactSplit)split).getAmountShare())
                .sum();

        if(Math.abs(totalExpenseAmount - splitContributionSum) > 1e-9) {
            throw new ExpenseSplitValidationException(
                    "Sum of contribution values in expense split != " + totalExpenseAmount +
                            ", contribution values found: " + Arrays.toString(splits.stream()
                            .mapToDouble(split -> ((ExactSplit) split).getAmountShare())
                            .toArray()),
                    null
            );
        }
    }
}