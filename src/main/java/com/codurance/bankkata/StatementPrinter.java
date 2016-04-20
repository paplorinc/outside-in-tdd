package com.codurance.bankkata;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;
import static java.util.stream.Collectors.toCollection;

public class StatementPrinter {
    protected static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private static final DecimalFormat decimalFormatter = new DecimalFormat("#.00");

    private final Console console;
    public StatementPrinter(Console console) { this.console = console; }

    public void print(List<Transaction> transactions) {
        console.println(STATEMENT_HEADER);

        printStatementLines(transactions);
    }

    private void printStatementLines(List<Transaction> transactions) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        transactions.stream()
                    .map(t -> statementLine(t, runningBalance))
                    .collect(toCollection(LinkedList::new))
                    .descendingIterator()
                    .forEachRemaining(console::println);
    }

    private String statementLine(Transaction transaction, AtomicInteger runningBalance) {
        return format("%s | %s | %s",
                      transaction.date(),
                      decimalFormatter.format(transaction.amount()),
                      decimalFormatter.format(runningBalance.addAndGet(transaction.amount())));
    }
}