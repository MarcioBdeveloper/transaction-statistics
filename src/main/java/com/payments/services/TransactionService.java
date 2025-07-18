package com.payments.services;


import com.payments.commom.Notification;
import com.payments.controllers.request.TransactionRequest;
import com.payments.exceptions.TransactionException;
import com.payments.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TransactionService implements TransactionServiceInt {

    Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private List<Transaction> transactionList = new ArrayList<>();

    @Override
    public void saveTransaction(TransactionRequest request) throws TransactionException {

        Notification notification = request.validate();

        if(notification.hasErrors()) {
            throw new TransactionException(notification.errorMessage());
        }

        transactionList.add(new Transaction(request.getValue(), request.getDateTime()));
        logger.info("Transaction save successfully");
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}
