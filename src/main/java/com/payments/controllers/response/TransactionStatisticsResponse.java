package com.payments.controllers.response;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.DoubleSummaryStatistics;

public record TransactionStatisticsResponse(long count, BigDecimal sum, BigDecimal min, BigDecimal max, BigDecimal avg) {
    public static TransactionStatisticsResponse doubleSummaryStatisticsToResponse(DoubleSummaryStatistics statistics) {
        return new TransactionStatisticsResponse(
                statistics.getCount(),
                BigDecimal.valueOf(statistics.getSum()),
                BigDecimal.valueOf(statistics.getMin() == Double.POSITIVE_INFINITY ? 0.0 : statistics.getMin()),
                BigDecimal.valueOf(statistics.getMax() == Double.NEGATIVE_INFINITY ? 0.0 : statistics.getMax()),
                BigDecimal.valueOf(statistics.getAverage()).setScale(2, RoundingMode.HALF_UP)
        );
    }
}
