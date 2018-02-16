package com.effective.atm;

public interface AtmLoginSession {
    /**
     * Login into account with appropriate pin.
     * If number of attempts to login exceeds max value,
     * exception will be thrown and card will be blocked.
     * @return AtmSession if pin is correct, otherwise null
     * @throws IllegalStateException if number of attempts exceeds max value.
     */
    AtmSession login(int pin);
}
