package com.codurance.bankkata;

public class Account {
    private final TransactionRepository transactionRepository;
    public Account(TransactionRepository transactionRepository) { this.transactionRepository = transactionRepository; }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }
    public void withdraw(int amount) {
    }
    public void printStatement() {
    }
}
