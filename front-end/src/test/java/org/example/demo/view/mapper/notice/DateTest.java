package org.example.demo.view.mapper.notice;

import javafx.application.Platform;
import org.example.demo.view.shared.Date;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class NoticeDate {
    private String date;

    public void setDate(LocalDateTime date) {
        Date d = new Date();
        d.setDate(date);
        this.date = d.toString();
    }

    public String getDate() {
        return date;
    }
}

class DateTest {
    @BeforeAll
    static void initJavaFX() {
        try {
            Platform.startup(() -> {});
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDateNull()  {
        assertThrows(NullPointerException.class,
                () -> {
            NoticeDate notice =
                    new NoticeDate();
            notice.setDate(null);
        });
    }

    @Test
    void testPastDateYear()  {
        NoticeDate view = new NoticeDate();
        view.setDate(LocalDateTime
                .now(ZoneOffset.UTC)
                .minusYears(3));

        assertNotNull(view);
        assertEquals("3 years ago", view
                .getDate());
    }

    @Test
    void testPastDateMonth()  {
        NoticeDate view = new NoticeDate();
        view.setDate(LocalDateTime
                .now(ZoneOffset.UTC)
                .minusMonths(11));

        assertNotNull(view);
        assertEquals("11 months ago", view
                .getDate());
    }

    @Test
    void testPastDateWeek()  {
        NoticeDate view = new NoticeDate();
        view.setDate(LocalDateTime
                .now(ZoneOffset.UTC)
                .minusDays(14));

        assertNotNull(view);
        assertEquals("2 weeks ago", view
                .getDate());
    }

    @Test
    void testPastDateDay()  {
        NoticeDate view = new NoticeDate();
        view.setDate(LocalDateTime
                .now(ZoneOffset.UTC)
                .minusDays(6));

        assertNotNull(view);
        assertEquals("6 days ago", view
                .getDate());
    }

    @Test
    void testPastDateHour()  {
        NoticeDate view = new NoticeDate();
        view.setDate(LocalDateTime
                .now(ZoneOffset.UTC)
                .minusHours(23));

        assertNotNull(view);
        assertEquals("23 hours ago", view
                .getDate());
    }

    @Test
    void testPastDateMinute()  {
        NoticeDate view = new NoticeDate();
        view.setDate(LocalDateTime
                .now(ZoneOffset.UTC)
                .minusMinutes(59));

        assertNotNull(view);
        assertEquals("59 minutes ago", view
                .getDate());
    }

    @Test
    void testPastDateSecond()  {
        NoticeDate view = new NoticeDate();
        view.setDate(LocalDateTime
                .now(ZoneOffset.UTC)
                .minusSeconds(5));

        assertNotNull(view);
        assertEquals("Just now", view
                .getDate());
    }

    @Test
    void testFutureDate()  {
        NoticeDate view = new NoticeDate();
        view.setDate(LocalDateTime
                .now(ZoneOffset.UTC)
                .plusMonths(5));

        assertNotNull(view);
        assertEquals("Just now", view
                .getDate());
    }
}