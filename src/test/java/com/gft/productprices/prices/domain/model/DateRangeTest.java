package com.gft.productprices.prices.domain.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

class DateRangeTest {

    @Test
    void shouldThrowExceptionWhenStartDateIsNull() {
        Date validEndDate = new Date();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new DateRange(null, validEndDate);
        });

        assertEquals("Start date and end date must not be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEndDateIsNull() {
        Date validStartDate = new Date();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new DateRange(validStartDate, null);
        });

        assertEquals("Start date and end date must not be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenStartDateIsAfterEndDate() {
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() - 1000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new DateRange(startDate, endDate);
        });

        assertEquals("The end date must be after the start date", exception.getMessage());
    }

    @Test
    void shouldCreateDateRangeWhenValidDatesAreProvided() {
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 1000);

        DateRange dateRange = new DateRange(startDate, endDate);

        assertNotNull(dateRange);
        assertEquals(startDate, dateRange.startDate());
        assertEquals(endDate, dateRange.endDate());
    }
}
