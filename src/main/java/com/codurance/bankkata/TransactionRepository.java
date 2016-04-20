package com.codurance.bankkata;

import javaslang.collection.*;

public class TransactionRepository {
    private final Clock clock;
    private Seq<Transaction> transactions = Vector.empty();
    public TransactionRepository(Clock clock) { this.clock = clock; }

    public void addDeposit(int amount) {
        Transaction deposit = new Transaction(clock.todayAsString(), amount);
        transactions = transactions.append(deposit);
    }

    public void addWithdrawal(int amount) {
        Transaction withdrawal = new Transaction(clock.todayAsString(), -amount);
        transactions = transactions.append(withdrawal);
    }

    public Seq<Transaction> allTransactions() {
        return transactions;
    }
}