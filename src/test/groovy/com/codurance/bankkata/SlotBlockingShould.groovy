package com.codurance.bankkata

import spock.lang.Specification

class SlotBlockingShould extends Specification {
    /**
     * Requirement:
     *
     * Slot Blocking for an application offering grocery delivery slots of one hour each
     * Service A: gives available slots (date ranges)
     * Service B: given a list of all slots, give me the ones that aren't blocked
     *
     * Slots can be blocked for every Monday 8-9 or one particular slot or over a period, e.g. for 2 months.
     *
     * Example:
     * given input: 8-9, 9-10, 12-13, 14-15 (always one hour)
     * and assuming the configuration filters out 9-10 and 15-17 every day (could be overlapping, but always starts and ends at full hour)
     * then your service should return 8-9,12-13,14-15 to the user
    */

    /*@formatter:off*/
    def 'return the available time slots for given intervals'() {
        given:  def intervals = new TimeIntervals(new TimeInterval(8, 9),
                                                  new TimeInterval(9, 10),
                                                  new TimeInterval(12, 13),
                                                  new TimeInterval(14, 15))
                def blocked = new TimeIntervals(new TimeInterval(9, 10),
                                                new TimeInterval(15, 17))
                def service = new FilteringService()
        when:   def available = service.filterOutBlocked(intervals, blocked)
        then:   available == new TimeIntervals(new TimeInterval(8, 9),
                                               new TimeInterval(12, 13),
                                               new TimeInterval(14, 15))
    }
    /*@formatter:on*/
}
