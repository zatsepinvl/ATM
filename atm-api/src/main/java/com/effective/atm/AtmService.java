package com.effective.atm;

/**
 * This interface represents basic operations over ATM
 */
public interface AtmService {
    boolean isCardExists(long cardNumber);

    boolean isCardBlocked(long cardNumber);

    /**
     * @return user session to perform operation over the card
     * @throws IllegalStateException if card doesn't exist or is blocked
     */
    AtmLoginSession enter(long cardNumber);
}
