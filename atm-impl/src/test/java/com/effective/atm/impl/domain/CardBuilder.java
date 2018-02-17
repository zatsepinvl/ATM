package com.effective.atm.impl.domain;

import java.math.BigDecimal;

public class CardBuilder {
    private final Card card;

    public CardBuilder() {
        card = new Card();
    }

    public CardBuilder cardNumber(long cardNumber) {
        card.setCardNumber(cardNumber);
        return this;
    }

    public CardBuilder pin(int pin) {
        card.setPin(pin);
        return this;
    }

    public CardBuilder blocked(boolean blocked) {
        card.setBlocked(blocked);
        return this;
    }

    public CardBuilder balance(BigDecimal balance) {
        card.setBalance(balance);
        return this;
    }

    public Card build() {
        return card;
    }
}
