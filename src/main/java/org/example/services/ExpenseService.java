package org.example.services;

import org.example.factories.ExpenseSplitterFactory;
import org.example.models.expense.Expense;
import org.example.models.split.ExactSplit;
import org.example.splitter.ExpenseSplitter;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private List<Expense> expenses;

    public ExpenseService() {
        this.expenses = new ArrayList<>();
    }

    public Expense addExpense(Expense expense) {

        ExpenseSplitter expenseSplitter = ExpenseSplitterFactory.getInstance(expense.getSplitType());

        List<ExactSplit> fixedSplits = expenseSplitter.toExactSplit(expense.getSplits(), expense.getTotalExpenseAmount());

        expenses.add(expense);

        return new Expense(
                expense.getExpenseId(),
                expense.getTotalExpenseAmount(),
                expense.getDescription(),
                fixedSplits,
                expense.getSplitType(),
                expense.getPaidUserId()
        );
    }

}
