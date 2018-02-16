package com.effective.atm;

import java.math.BigDecimal;

/**
 * This interface represents user session with ATM
 * @see AtmService#enter(long)
 */
public interface AtmSession {

    BigDecimal getBalance();

    /**
     * @return remaining balance
     * @throws IllegalArgumentException if requested cash
     * amount greater than balance
     */
    BigDecimal withdrawCash(BigDecimal amount);
}
