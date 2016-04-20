package com.codurance.bankkata

import spock.lang.Specification

import java.time.LocalDate

class ClockShould extends Specification {
    /*@formatter:off*/
    def "return today's date in dd/MM/yyyy format"() {
        def (day, month, year)= ['24','04','2015']
        when:   def clock = [today: { LocalDate.parse("$year-$month-$day") }] as Clock
        then:   clock.todayAsString() == "$day/$month/$year"
    }
    /*@formatter:on*/
}
