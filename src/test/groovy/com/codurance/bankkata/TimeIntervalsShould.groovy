package com.codurance.bankkata

import javaslang.control.Option
import spock.lang.Specification

class TimeIntervalsShould extends Specification {
    /*@formatter:off*/
    def 'return time interval for a given start time'() {
        when:   def timeSlots = new TimeIntervals(new TimeInterval(8, 9),
                                                  new TimeInterval(9, 10),
                                                  new TimeInterval(12,13),
                                                  new TimeInterval(14, 15))
        then:   def expectedResults = [(8): 9, (9): 10, (12): 13, (14): 15]
                expectedResults.each { start, end ->
                    assert timeSlots.getInterval(start) == Option.some(new TimeInterval(start, end))
                }
    }
    /*@formatter:on*/
}