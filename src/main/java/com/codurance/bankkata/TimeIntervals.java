package com.codurance.bankkata;

import javaslang.collection.List;
import javaslang.control.Option;

import java.util.Objects;
import java.util.function.Predicate;

public class TimeIntervals {
    private final List<TimeInterval> timeIntervals;
    public TimeIntervals(TimeInterval... timeIntervals) {
        this(List.of(timeIntervals));
    }

    private TimeIntervals(List<TimeInterval> timeIntervals) {
        this.timeIntervals = timeIntervals;
    }

    public Option<TimeInterval> getInterval(int start) {
        return timeIntervals.find(t -> t.getStart() == start);
    }

    public TimeIntervals filter(Predicate<TimeInterval> predicate) {
        List<TimeInterval> filtered = timeIntervals.filter(predicate);
        return new TimeIntervals(filtered);
    }

    public boolean contains(TimeInterval interval) {
        return timeIntervals.contains(interval);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        else if (o == null || getClass() != o.getClass()) return false;

        TimeIntervals that = (TimeIntervals) o;
        return Objects.equals(timeIntervals, that.timeIntervals);
    }
    @Override public int hashCode() { return Objects.hash(timeIntervals); }
}

