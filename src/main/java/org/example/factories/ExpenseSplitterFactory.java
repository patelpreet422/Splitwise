package org.example.factories;

import org.example.exceptions.NoExpenseSplitterFound;
import org.example.models.split.ExpenseSplitType;
import org.example.splitter.EqualExpenseSplitter;
import org.example.splitter.ExactExpenseSplitter;
import org.example.splitter.ExpenseSplitter;
import org.example.splitter.PercentageExpenseSplitter;

public class ExpenseSplitterFactory {
    public static ExpenseSplitter getInstance(ExpenseSplitType expenseSplitType) {
        switch (expenseSplitType) {
            case EQUAL_SPLIT:
                return new EqualExpenseSplitter();
            case EXACT_SPLIT:
                return new ExactExpenseSplitter();
            case PERCENTAGE_SPLIT:
                return new PercentageExpenseSplitter();
            default:
                throw new NoExpenseSplitterFound(
                        "No expense splitter for expenense split type: " + expenseSplitType + " can be found",
                        null
                );
        }

    }
}