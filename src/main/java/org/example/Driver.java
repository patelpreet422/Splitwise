package org.example;

import org.example.models.expense.Expense;
import org.example.models.split.EqualSplit;
import org.example.models.split.ExactSplit;
import org.example.models.split.ExpenseSplitType;
import org.example.models.split.PercentageSplit;
import org.example.services.SplitwiseService;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        SplitwiseService splitwiseService = new SplitwiseService();

        splitwiseService.addExpense(new Expense(
                "expense1",
                10.,
                "",
                Arrays.asList(new EqualSplit("kushal"), new EqualSplit("preet")),
                ExpenseSplitType.EQUAL_SPLIT,
                "kushal"
            )
        );

        splitwiseService.addExpense(new Expense(
                "expense2",
                100.,
                "",
                Arrays.asList(new PercentageSplit("kushal", 80), new PercentageSplit("preet", 20)),
                ExpenseSplitType.PERCENTAGE_SPLIT,
                "preet"
            )
        );

        splitwiseService.addExpense(new Expense(
                "expense3",
                10.,
                "",
                Arrays.asList(new EqualSplit("kushal"), new EqualSplit("preet")),
                ExpenseSplitType.EQUAL_SPLIT,
                "kushal"
            )
        );

        splitwiseService.addExpense(new Expense(
                "expense4",
                240.,
                "",
                Arrays.asList(new ExactSplit("kushal", 80), new ExactSplit("preet", 80), new ExactSplit("bipul", 80)),
                ExpenseSplitType.EXACT_SPLIT,
                "bipul"
            )
        );

        splitwiseService.showBalancesForUser("preet");
//        splitwiseService.showBalancesForUser("kushal");

        System.out.printf("Amount to be paid by sender: %f\n",
                splitwiseService.settlePayment("preet", "kushal")
        );

        System.out.println("After settlement between preet and kushal");

        splitwiseService.showBalancesForUser("preet");
//        splitwiseService.showBalancesForUser("kushal");
    }
}
