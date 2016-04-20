package com.codurance.bankkata

import spock.lang.Specification

class AccountShould extends Specification {
    TransactionRepository transactionRepository = Mock()
    StatementPrinter statementPrinter = Mock()

    def account = new Account(transactionRepository, statementPrinter)

    /*@formatter:off*/
    def 'store a deposit transaction'() {
        given:  def value = 100
        when:   account.deposit(value)
        then:   1 * transactionRepository.addDeposit(value)
    }

    def 'store a withdrawal transaction'() {
        given:  def value = 100
        when:   account.withdraw(value)
        then:   1 * transactionRepository.addWithdrawal(value)
    }

    def 'print a statement'() {
        given:  def transactions = [new Transaction()]
                transactionRepository.allTransactions() >> transactions
        when:   account.printStatement()
        then:   1 * statementPrinter.print(transactions)
    }
    /*@formatter:on*/
}