package com.payments.services;

import com.payments.commom.Notification;
import com.payments.controllers.request.TransactionRequest;
import com.payments.exceptions.TransactionException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TransactionServiceTest {

    @Test
    public void whenCallSaveTransactionWithValidRequestResultSuccess() throws TransactionException {
        TransactionRequest requestMock = mock(TransactionRequest.class);
        Notification notification = new Notification();

        when(requestMock.validate()).thenReturn(notification);
        TransactionService service = new TransactionService();
        service.saveTransaction(requestMock);
        assertEquals(1, service.getTransactionList().size());
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
