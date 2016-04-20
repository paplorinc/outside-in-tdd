package com.codurance.bankkata

import spock.lang.Specification

class AccountShould extends Specification {
    TransactionRepository transactionRepository = Mock()
    StatementPrinter statementPrinter = Mock()

    def account = new Account(transactionRepository, statementPrinter)

    /*@formatter:off*/
    def 'store a deposit transaction'() {
        given:  def amount = 100
        when:   account.deposit(amount)
        then:   1 * transactionRepository.addDeposit(amount)
    }

    def 'store a withdrawal transaction'() {
        given:  def amount = 100
        when:   account.withdraw(amount)
        then:   1 * transactionRepository.addWithdrawal(amount)
    }

    def 'print a statement'() {
        given:  def transactions = [new Transaction('12/05/2015', 100)]
                transactionRepository.allTransactions() >> transactions
        when:   account.printStatement()
        then:   1 * statementPrinter.print(transactions)
    }
    /*@formatter:on*/
}