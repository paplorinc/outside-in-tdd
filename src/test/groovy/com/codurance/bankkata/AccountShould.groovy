package com.codurance.bankkata

import spock.lang.Specification

class AccountShould extends Specification {
    def transactionRepository = Mock(TransactionRepository)

    def account = new Account(transactionRepository)

    /*@formatter:off*/
    def 'store a deposit transaction'() {
        given:  def value = 100
        when:   account.deposit(value)
        then:   1 * transactionRepository.addDeposit(value)
    }
    /*@formatter:on*/
}