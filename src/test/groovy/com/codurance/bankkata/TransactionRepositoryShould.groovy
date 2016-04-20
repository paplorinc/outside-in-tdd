package com.codurance.bankkata

import spock.lang.Specification

class TransactionRepositoryShould extends Specification {
    Clock clock = Mock()

    final transactionRepository = new TransactionRepository(clock)

    /*@formatter:off*/
    def 'create and store a deposit transaction'() {
        final amount = 100
        final today = '12/05/2015'

        given:  clock.todayAsString() >>  today

        when:   transactionRepository.addDeposit(amount)
                final transactions = transactionRepository.allTransactions()

        then:   transactions.size() == 1
                transactions.first() == transaction(today, amount)
    }

    def 'create and store a withdrawal transaction'() {
        final amount = 100
        final today = '12/05/2015'

        given:  clock.todayAsString() >>  today

        when:   transactionRepository.addWithdrawal(amount)
                final transactions = transactionRepository.allTransactions()

        then:   transactions.size() == 1
                transactions.first() == transaction(today, -amount)
    }
    /*@formatter:on*/

    def transaction(String date, int amount) { new Transaction(date, amount) }
}
