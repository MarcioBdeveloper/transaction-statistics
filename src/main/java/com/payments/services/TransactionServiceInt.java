package com.payments.services;

import com.payments.model.Transaction;
import com.payments.controllers.request.TransactionRequest;

public interface TransactionServiceInt {
   void saveTransaction(TransactionRequest request);
}
