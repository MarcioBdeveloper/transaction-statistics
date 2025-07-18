package com.payments.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


public class Transaction {

    private BigDecimal value;
    private OffsetDateTime dateTime;

    public Transaction(BigDecimal value, OffsetDateTime dateTime) {
        this.value = value;
        this.dateTime = dateTime;
    }

    public Transaction() {
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
