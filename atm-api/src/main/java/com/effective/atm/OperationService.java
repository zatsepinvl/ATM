package com.effective.atm;

import com.effective.atm.domain.Operation;

/**
 * This interface represents basic methods
 * to work with ATM operations
 */
public interface OperationService {

    /**
     * @throws IllegalArgumentException if card doesn't exist or is blocked
     */
    Iterable<Operation> getOperations(long cardNumber);
}
