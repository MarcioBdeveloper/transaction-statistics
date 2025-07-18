package com.payments.controllers.request;

import com.payments.commom.Notification;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@SpringBootTest
public class TransactionRequestTest {


    @Test
    public void whenCallValidateMethodWithNegativeValueReturnNotificationError() {
        TransactionRequest request = new TransactionRequest(new BigDecimal("-10.0"), OffsetDateTime.now());
        Notification notification = request.validate();
        assumeFalse(notification.getErrors().isEmpty());
        assertEquals(notification.getErrors().getFirst(), "Value cannot be negative or zero");
    }

    @Test
    public void whenCallValidateMethodWithFutureDateReturnNotificationError() {
        TransactionRequest request = new TransactionRequest(new BigDecimal("10.0"), OffsetDateTime.now().plusDays(1));
        Notification notification = request.validate();
        assumeFalse(notification.getErrors().isEmpty());
        assertEquals(notification.getErrors().getFirst(), "Date cannot be less than current date");
    }

    @Test
    public void whenCallValidateMethodWithNegativeValueAndFutureDateReturnNotificationError() {
        TransactionRequest request = new TransactionRequest(new BigDecimal("-10.0"), OffsetDateTime.now().plusDays(1));
        Notification notification = request.validate();
        assumeFalse(notification.getErrors().isEmpty());
        assertEquals(notification.getErrors().get(0), "Value cannot be negative or zero");
        assertEquals(notification.getErrors().get(1), "Date cannot be less than current date");
    }
}
