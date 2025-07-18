package com.payments.services;

import com.payments.exceptions.TransactionException;
import com.payments.controllers.request.TransactionRequest;

public interface TransactionServiceInt {
   void saveTransaction(TransactionRequest request) throws TransactionException;
   void deleteTransactions() throws TransactionException;
}
