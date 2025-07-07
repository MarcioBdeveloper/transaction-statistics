package com.payments.controllers.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransactionRequest {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private BigDecimal value;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private OffsetDateTime dateTime;

    public TransactionRequest(BigDecimal value, OffsetDateTime dateTime) {
        this.value = value;
        this.dateTime = dateTime;
    }

    public TransactionRequest() {
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
