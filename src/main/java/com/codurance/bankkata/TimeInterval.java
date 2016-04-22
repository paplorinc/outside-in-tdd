package com.codurance.bankkata;

import java.util.Objects;

import static java.lang.String.format;

class TimeInterval {
    private final int start, end;
    public TimeInterval(int start, int end) {
        // TODO validate input
        this.start = start;
        this.end = end;
    }

    public int getStart() { return start; }
    public int getEnd() { return end; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        else if (o == null || getClass() != o.getClass()) return false;

        TimeInterval that = (TimeInterval) o;
        return start == that.start
               && end == that.end;
    }
    @Override public int hashCode() { return Objects.hash(start, end); }
    @Override public String toString() {
        return format("TimeInterval{start=%d, end=%d}",
                      start, end);
    }
}
