package com.effective.atm.impl;

import com.effective.atm.impl.domain.Card;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardTest {
    @Test
    public void check_pin() {
        int pin = 1111;
        Card card = new Card();
        card.setPin(pin);
        assertTrue(card.checkPin(pin));
        assertFalse(card.checkPin(pin + 1));
    }
}
