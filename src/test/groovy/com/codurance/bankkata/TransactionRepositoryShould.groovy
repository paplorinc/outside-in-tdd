package com.codurance.bankkata

import spock.lang.Specification

class TransactionRepositoryShould extends Specification {
    Clock clock = Mock()

    def transactionRepository = new TransactionRepository(clock)

    /*@formatter:off*/
    def 'create and store a deposit transaction'() {
        def amount = 100
        def today = '12/05/2015'

        given:  clock.todayAsString() >>  today

        when:   transactionRepository.addDeposit(amount)
                def transactions = transactionRepository.allTransactions()

        then:   transactions.size() == 1
                transactions.first() == transaction(today, amount)
    }
    /*@formatter:on*/

    def transaction(String date, int amount) { new Transaction(date, amount) }
}
