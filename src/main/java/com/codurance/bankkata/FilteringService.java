package com.codurance.bankkata;

public class FilteringService {
    public TimeIntervals filterOutBlocked(TimeIntervals allIntervals, TimeIntervals blocked) {
        return allIntervals.filter(interval -> !blocked.contains(interval));
    }
}
