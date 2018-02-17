package com.effective.atm;

import java.math.BigDecimal;

/**
 * This interface represents user session with ATM
 * @see AtmService#enter(long)
 */
public interface AtmSession {
    /**
     * Login into account with appropriate pin.
     * If number of attempts to login exceeds max value,
     * exception will be thrown and card will be blocked.
     * @return true if pin correct and false if not
     * @throws IllegalStateException if number of attempts exceeds max value.
     */
    boolean login(int pin);

    BigDecimal getBalance();

    /**
     * @return remaining balance
     * @throws IllegalArgumentException if requested cash
     * amount greater than balance
     */
    BigDecimal withdrawCash(BigDecimal amount);
}
