package org.example.services;

import org.example.models.BalanceSheet;
import org.example.models.expense.Expense;
import org.example.models.split.ExactSplit;
import org.example.models.split.Split;

import java.util.Map;
import java.util.TreeMap;

public class BalanceSheetService {
    private Map<String, BalanceSheet> usersBalanceSheet;

    public BalanceSheetService() {
        this.usersBalanceSheet = new TreeMap<>();
    }

    public void updateBalanceSheet(Expense expense) {
        for(Split split: expense.getSplits()) {

            ExactSplit exactSplit = (ExactSplit) split;

            String payeeId = split.getUserId();

            recordPayment(expense.getPaidUserId(), payeeId, exactSplit.getAmountShare());
        }

    }

    public BalanceSheet getBalanceSheet(String user) {
        return usersBalanceSheet.get(user);
    }

    public void recordPayment(String senderId, String receiverId, double amount) {
        BalanceSheet senderBalanceSheet = usersBalanceSheet.getOrDefault(senderId, new BalanceSheet(senderId, new TreeMap<>(), new TreeMap<>()));
        BalanceSheet receiverBalanceSheet = usersBalanceSheet.getOrDefault(receiverId, new BalanceSheet(receiverId, new TreeMap<>(), new TreeMap<>()));

        double previousGiven = senderBalanceSheet.getGivenAmount().getOrDefault(receiverId, 0.);
        double previousOwed = receiverBalanceSheet.getOwedAmount().getOrDefault(senderId, 0.);

        assert previousOwed == previousGiven;

        senderBalanceSheet.getGivenAmount().put(receiverId, amount + previousGiven);
        receiverBalanceSheet.getOwedAmount().put(senderId, amount + previousOwed);

        usersBalanceSheet.put(senderId, senderBalanceSheet);
        usersBalanceSheet.put(receiverId, receiverBalanceSheet);
    }

    public double settleOwedAmount(String senderId, String receiverId) {
        BalanceSheet senderBalanceSheet = usersBalanceSheet.getOrDefault(senderId, new BalanceSheet(senderId, new TreeMap<>(), new TreeMap<>()));
        BalanceSheet receiverBalanceSheet = usersBalanceSheet.getOrDefault(receiverId, new BalanceSheet(receiverId, new TreeMap<>(), new TreeMap<>()));

        double givenAmount = senderBalanceSheet.getGivenAmount().getOrDefault(receiverId, 0.);
        double owedAmount = senderBalanceSheet.getOwedAmount().getOrDefault(receiverId, 0.);

        double netCashFlow = givenAmount - owedAmount;

        senderBalanceSheet.getGivenAmount().put(receiverId, 0.);
        senderBalanceSheet.getOwedAmount().put(receiverId, 0.);

        receiverBalanceSheet.getGivenAmount().put(senderId, 0.);
        receiverBalanceSheet.getOwedAmount().put(senderId, 0.);

        usersBalanceSheet.put(senderId, senderBalanceSheet);
        usersBalanceSheet.put(receiverId, receiverBalanceSheet);

        return netCashFlow;
    }
}