package com.payments.services;

import com.payments.commom.Notification;
import com.payments.controllers.request.TransactionRequest;
import com.payments.exceptions.TransactionException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TransactionServiceTest {

    @MockitoBean
    public TransactionService transactionService;

    @Test
    public void whenCallSaveTransactionWithValidRequestResultSuccess() throws TransactionException {
        TransactionRequest request = new TransactionRequest(new BigDecimal("10.0"), OffsetDateTime.now());

        transactionService.saveTransaction(request);
        assertEquals(1, transactionService.getTransactionList().size());
    }

    @Test
    public void whenCallSaveTransactionWithValidRequestResultError() {

        TransactionRequest requestMock = mock(TransactionRequest.class);
        Notification notification = new Notification();
        notification.addError("Value cannot be negative or zero");
        notification.addError("Date cannot be less than current date");

        TransactionService service = new TransactionService();

        when(requestMock.validate()).thenReturn(notification);

        TransactionException thrown = assertThrows(TransactionException.class, () -> {
            service.saveTransaction(requestMock);
        });

        assertTrue(thrown.getMessage().contains("Value cannot be negative or zero"));
        assertTrue(thrown.getMessage().contains("Date cannot be less than current date"));
    }
}
