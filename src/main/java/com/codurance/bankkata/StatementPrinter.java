package com.codurance.bankkata;

import javaslang.collection.Seq;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;

public class StatementPrinter {
    protected static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");

    private final Console console;
    public StatementPrinter(Console console) { this.console = console; }

    public void print(Seq<Transaction> transactions) {
        console.println(STATEMENT_HEADER);
        statements(transactions).forEach(console::println);
    }

    private Iterable<String> statements(Seq<Transaction> transactions) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        return transactions.map(t -> statementLine(t, runningBalance))
                           .reverseIterator();
    }

    private static String statementLine(Transaction transaction, AtomicInteger runningBalance) {
        String date = transaction.date();
        int amount = transaction.amount();
        return format("%s | %s | %s",
                      date,
                      DECIMAL_FORMAT.format(amount),
                      DECIMAL_FORMAT.format(runningBalance.addAndGet(amount)));
    }
}