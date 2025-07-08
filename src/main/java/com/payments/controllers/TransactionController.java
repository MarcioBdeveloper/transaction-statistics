package com.payments.controllers;


import com.payments.controllers.request.TransactionRequest;
import com.payments.exceptions.TransactionException;
import com.payments.services.TransactionService;
import com.payments.services.TransactionServiceInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/transaction")
@RestController
public class TransactionController {

    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    private static TransactionServiceInt transactionService;

    @PostMapping
    public ResponseEntity newTransaction(@RequestBody TransactionRequest transactionRequest) throws TransactionException {
        logger.info("Transaction received");
        transactionService.saveTransaction(transactionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
