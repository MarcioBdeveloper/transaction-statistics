package com.payments.controllers.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.payments.commom.Notification;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransactionRequest {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private BigDecimal value;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private OffsetDateTime dateTime;

    public TransactionRequest(BigDecimal value, OffsetDateTime dateTime) {
        this.value = value;
        this.dateTime = dateTime;
    }

    public TransactionRequest() {
    }

    public Notification validate() {
        Notification notification = new Notification();
        OffsetDateTime now = OffsetDateTime.now();

        if (this.value == null || this.value.compareTo(BigDecimal.ZERO) <= 0) {
            notification.addError("Value cannot be negative or zero");
        }

        if (dateTime.isAfter(now)) {
            notification.addError("Date cannot be less than current date");
        }

        return notification;
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
