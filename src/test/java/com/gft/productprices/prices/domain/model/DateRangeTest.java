package com.gft.productprices.prices.domain.model;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateRangeTest {

    @Test
    void testValidDateRange() {
        Date startDate = new Date(0); // January 1, 1970
        Date endDate = new Date(10000); // January 1, 1970 (10,000 milliseconds later)

        DateRange dateRange = new DateRange(startDate, endDate);

        assertNotNull(dateRange);
    }

    @Test
    void testNullStartDate() {
        Date endDate = new Date();

        assertThrows(IllegalArgumentException.class, () -> new DateRange(null, endDate));
    }

    @Test
    void testNullEndDate() {
        Date startDate = new Date();

        assertThrows(IllegalArgumentException.class, () -> new DateRange(startDate, null));
    }

    @Test
    void testEndDateBeforeStartDate() {
        Date startDate = new Date();
        Date endDate = new Date(0); // Earlier date

        assertThrows(IllegalArgumentException.class, () -> new DateRange(startDate, endDate));
    }
}
