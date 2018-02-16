package com.effective.atm.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Operation {
    private final long cardNumber;
    private final long time;
    private final String operationCode;
    private final BigDecimal balanceChange;

    public Operation(
            long cardNumber,
            long time,
            String operationCode,
            BigDecimal balanceChange
    ) {
        this.cardNumber = cardNumber;
        this.time = time;
        this.operationCode = operationCode;
        this.balanceChange = balanceChange;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public long getTime() {
        return time;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public BigDecimal getBalanceChange() {
        return balanceChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return cardNumber == operation.cardNumber &&
                time == operation.time &&
                Objects.equals(operationCode, operation.operationCode) &&
                Objects.equals(balanceChange, operation.balanceChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, time, operationCode, balanceChange);
    }
}
