package com.codurance.bankkata;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;

public class Clock {
    public String todayAsString() {
        LocalDate today = today();
        return today.format(ofPattern("dd/MM/yyyy"));
    }

    protected LocalDate today() { return LocalDate.now(); }
}
