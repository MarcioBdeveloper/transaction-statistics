package com.payments.services;


import com.payments.TransactionRepository;
import com.payments.controllers.request.TransactionRequest;
import com.payments.exceptions.TransactionException;
import com.payments.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Service
public class TransactionService implements TransactionServiceInt {

    private static TransactionRepository transactionRepository;
    Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Override
    public void saveTransaction(TransactionRequest request) throws TransactionException {

        boolean valueIsNotValid = request.getValue().signum() == -1 || request.getValue().compareTo(BigDecimal.ZERO) == 0;
        if(valueIsNotValid) {
            throw new TransactionException("Value cannot be negative or zero");
        }

        OffsetDateTime now = OffsetDateTime.now();
        if(request.getDateTime().isAfter(now)) {
            throw new TransactionException("Date cannot be less than current date");
        }

        Transaction transaction = new Transaction(request.getValue(), request.getDateTime());
        transactionRepository.save(transaction);
        logger.info("Transaction save successfully");
    }
}
