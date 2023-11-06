package com.gft.productprices.prices.domain.model;

import java.util.Date;

public record DateRange(Date startDate, Date endDate) {
    public DateRange {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date must not be null");
        }
        if (startDate.after(endDate)) {
            throw new IllegalArgumentException("The end date must be after the start date");
        }
    }
}