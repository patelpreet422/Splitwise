package org.example.services;

import org.example.models.BalanceSheet;
import org.example.models.User;
import org.example.models.expense.Expense;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SplitwiseService {
    UserService userService;
    ExpenseService expenseService;
    BalanceSheetService balanceSheetService;

    public SplitwiseService() {
        this.userService = new UserService();
        this.expenseService = new ExpenseService();
        this.balanceSheetService = new BalanceSheetService();
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public void addExpense(Expense expense) {
        expenseService.addExpense(expense);
        Expense normalizedExpense = expenseService.normalizeExpense(expense);
        balanceSheetService.updateBalanceSheet(normalizedExpense);
    }

    public double settlePayment(String senderId, String receiverId) {
        return balanceSheetService.settleOwedAmount(senderId, receiverId);
    }

    public BalanceSheet getBalanceSheetOfUser(String userId) {
        return balanceSheetService.getBalanceSheet(userId);
    }

    public void showBalancesForUser(String userId) {
        BalanceSheet userBalanceSheet = balanceSheetService.getBalanceSheet(userId);

        Map<String, Double> givenAmount = userBalanceSheet.getGivenAmount();
        Map<String, Double> owedAmount = userBalanceSheet.getOwedAmount();

        Set<String> usersTransactedWith = new TreeSet<>(givenAmount.keySet());
        usersTransactedWith.addAll(owedAmount.keySet());

        for(String user: usersTransactedWith) {
            if(Objects.equals(user, userId)) {
                continue;
            }
            double netCashFlow = owedAmount.getOrDefault(user, 0.) -
                    givenAmount.getOrDefault(user, 0.);

            System.out.println(userId + " -> " + user + ": " + netCashFlow);
        }
    }
}