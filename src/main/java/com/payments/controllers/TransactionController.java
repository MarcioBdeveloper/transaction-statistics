package com.payments.controllers;


import com.payments.controllers.request.TransactionRequest;
import com.payments.controllers.response.TransactionStatisticsResponse;
import com.payments.exceptions.TransactionException;
import com.payments.services.TransactionServiceInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;

@RequestMapping("/transaction")
@RestController
public class TransactionController {

    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionServiceInt transactionService;

    public TransactionController(TransactionServiceInt transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> newTransaction(@RequestBody TransactionRequest transactionRequest) throws TransactionException {
        logger.info("Transaction received");
        transactionService.saveTransaction(transactionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransactions() throws TransactionException {
        logger.info("Delete transactions");
        transactionService.deleteTransactions();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/statistic")
    public ResponseEntity<TransactionStatisticsResponse> transactionStatistics() throws TransactionException {
        logger.info("Transactions statistics");
        DoubleSummaryStatistics statistics = transactionService.transactionStatistics();
        return ResponseEntity.ok(TransactionStatisticsResponse.doubleSummaryStatisticsToResponse(statistics));
    }

}
