package com.codurance.bankkata

import javaslang.collection.Array
import spock.lang.Specification

class AccountShould extends Specification {
    static DUMMY_DATE = '12/05/2015'

    TransactionRepository transactionRepository = Mock()
    StatementPrinter statementPrinter = Mock()

    final account = new Account(transactionRepository, statementPrinter)

    /*@formatter:off*/
    def 'store a deposit transaction'() {
        final amount = 100

        when:   account.deposit(amount)
        then:   1 * transactionRepository.addDeposit(amount)
    }

    def 'store a withdrawal transaction'() {
        final amount = 100

        when:   account.withdraw(amount)
        then:   1 * transactionRepository.addWithdrawal(amount)
    }

    def 'print a statement'() {
        final amount = 100
        final transactions = Array.of(new Transaction(DUMMY_DATE, amount))

        given:  transactionRepository.allTransactions() >> transactions
        when:   account.printStatement()
        then:   1 * statementPrinter.print(transactions)
    }
    /*@formatter:on*/
}