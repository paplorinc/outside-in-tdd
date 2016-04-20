package com.codurance.bankkata

import javaslang.collection.Vector
import spock.lang.Specification

import static com.codurance.bankkata.StatementPrinter.STATEMENT_HEADER

class StatementPrinterShould extends Specification {
    Console console = Mock()

    /*@formatter:off*/
    def 'always print the header'() {
        given:  final statementPrinter = new StatementPrinter(console)
                final noTransactions = Vector.empty()

        when:   statementPrinter.print(noTransactions)

        then:   1 * console.println(STATEMENT_HEADER)
    }

    def 'print transactions in revers chronological order'() {
        given:  final statementPrinter = new StatementPrinter(console)
                final transactions = Vector.of(deposit('01/04/2014', 1000),
                                               withdrawal('02/04/2014', 100),
                                               deposit('10/04/2014', 500))

        when:   statementPrinter.print(transactions)

        then:   1 * console.println(STATEMENT_HEADER)
        then:   1 * console.println('10/04/2014 | 500.00 | 1400.00')
        then:   1 * console.println("02/04/2014 | -100.00 | 900.00")
        then:   1 * console.println("01/04/2014 | 1000.00 | 1000.00")
    }
    /*@formatter:on*/

    def deposit(String date, int amount) { new Transaction(date, amount) }
    def withdrawal(String date, int amount) { new Transaction(date, -amount) }
}
