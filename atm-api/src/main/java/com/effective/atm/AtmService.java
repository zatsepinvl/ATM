package com.effective.atm;

/**
 * This interface represents basic operations over ATM
 */
public interface AtmService {
    boolean isCardExists(long cardNumber);

    /**
     * @throws IllegalArgumentException if card doesn't exist
     */
    boolean isCardBlocked(long cardNumber);

    /**
     * @return user session to perform operation over the card
     * @throws IllegalArgumentException if card doesn't exist or is blocked
     */
    AtmSession enter(long cardNumber);
}
