package com.payments.services;


import com.payments.TransactionRepository;
import com.payments.controllers.request.TransactionRequest;
import com.payments.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class TransactionService implements TransactionServiceInt {

    private static TransactionRepository transactionRepository;
    Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Override
    public void saveTransaction(TransactionRequest request) {
        Transaction transaction = new Transaction(request.getValue(), request.getDateTime());
        transactionRepository.save(transaction);
        logger.info("Transaction save successfully");
    }
}
