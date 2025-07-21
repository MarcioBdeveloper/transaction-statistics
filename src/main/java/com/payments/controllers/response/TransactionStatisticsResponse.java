package com.payments.controllers.response;

import java.math.BigDecimal;

public record TransactionStatisticsResponse(long count, BigDecimal sum, BigDecimal min, BigDecimal max, BigDecimal avg) {}
