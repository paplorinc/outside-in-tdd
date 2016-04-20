package com.codurance.bankkata

import spock.lang.*

@Unroll class PrintStatementFeature extends Specification {
    /*@formatter:off*/
    def console = Mock(Console)
    def account = new Account(new TransactionRepository())

    @PendingFeature
    def 'print statement containing all transactions'() {
        given:  account.deposit(1000)
                account.withdraw(100)
                account.deposit(500)

        when:   account.printStatement()

        then:   1 * console.println('DATE | AMOUNT | BALANCE')
        then:   1 * console.println('10/04/2014 | 500.00 | 1400.00')
        then:   1 * console.println('02/04/2014 | -100.00 | 900.00')
        then:   1 * console.println('01/04/2014 | 1000.00 | 1000.00')
    }
    /*@formatter:on*/
}