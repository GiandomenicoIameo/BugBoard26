package org.example.demo.view.shared;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Date {
    private long day;
    private long month;
    private long year;

    private long hour;
    private long minute;

    public void setDate(LocalDateTime utc) {
        if (utc == null)
            throw new NullPointerException(
                    "Data non disponibile");

        LocalDateTime now = LocalDateTime
                .now(ZoneOffset.UTC);

        year   = ChronoUnit.
                YEARS.between(utc, now);
        month  = ChronoUnit
                .MONTHS.between(utc, now);
        day    = ChronoUnit
                .DAYS.between(utc, now);
        hour   = ChronoUnit
                .HOURS.between(utc, now);
        minute = ChronoUnit
                .MINUTES.between(utc, now);
    }

    private String ago(long n, String unit) {
        return n + " " + unit + (n == 1 ? "" : "s") + " ago";
    }

    @Override
    public String toString() {
        if(this.year > 0)
            return ago(this.year, "year");
        if(this.month > 0)
            return ago(this.month, "month");
        if(this.day >= 7)
            return ago(this.day / 7, "week");
        if(this.day > 0)
            return ago(this.day, "day");
        if(this.hour > 0)
            return ago(this.hour, "hour");
        if(this.minute > 0)
            return ago(this.minute, "minute");
        return "Just now";
    }
}
