package com.codurance.bankkata

import spock.lang.Specification

class StatementPrinterShould extends Specification {
    Console console = Mock()

    def NO_TRANSACTIONS = []

    /*@formatter:off*/
    def 'always print the header'() {
        given:  def statementPrinter = new StatementPrinter(console)
        when:   statementPrinter.print(NO_TRANSACTIONS)
        then:   1 * console.println('DATE | AMOUNT | BALANCE')
    }
    /*@formatter:on*/
}
