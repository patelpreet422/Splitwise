package org.example.services;

import org.example.factories.ExpenseSplitterFactory;
import org.example.models.expense.Expense;
import org.example.models.split.ExactSplit;
import org.example.models.split.ExpenseSplitType;
import org.example.splitter.ExpenseSplitter;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private List<Expense> expenses;

    public ExpenseService() {
        this.expenses = new ArrayList<>();
    }

    public boolean addExpense(Expense expense) {
        return expenses.add(expense);
    }
    
    public Expense normalizeExpense(Expense expense) {
        ExpenseSplitter expenseSplitter = ExpenseSplitterFactory.getInstance(expense.getSplitType());

        List<ExactSplit> exactSplits = expenseSplitter.toExactSplit(expense.getSplits(), expense.getTotalExpenseAmount());

        return new Expense(
                expense.getExpenseId() + "normalized",
                expense.getTotalExpenseAmount(),
                expense.getDescription(),
                exactSplits,
                ExpenseSplitType.EXACT_SPLIT,
                expense.getPaidUserId()
        );
    }
}
