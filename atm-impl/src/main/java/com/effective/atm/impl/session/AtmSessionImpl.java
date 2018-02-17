package com.effective.atm.impl.session;

import com.effective.atm.AtmSession;
import com.effective.atm.impl.domain.Card;
import com.effective.atm.impl.repository.CardRepository;

import java.math.BigDecimal;

public class AtmSessionImpl implements AtmSession {
    private static final int MAX_LOGIN_ATTEMPTS = 4;
    private final CardRepository cardRepository;

    private final long cardNumber;
    private int loginAttempts;
    private boolean loggedIn;

    AtmSessionImpl(
            CardRepository cardRepository,
            long cardNumber
    ) {
        this.cardRepository = cardRepository;
        this.cardNumber = cardNumber;
        loginAttempts = 0;
        loggedIn = false;
    }

    @Override
    public boolean login(int pin) {
        Card card = card();
        assertCardBlocked(card);
        loggedIn = card.checkPin(pin);
        if (loggedIn) {
            loginAttempts = 0;
        } else {
            loginAttempts++;
            if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                card.setBlocked(true);
                cardRepository.save(card);
                throw new IllegalStateException("Login attempts exceeds max number. Card was blocked");
            }
        }
        return loggedIn;
    }

    @Override
    public BigDecimal getBalance() {
        assertLogin();
        Card card = card();
        assertCardBlocked(card);
        return card.getBalance();
    }

    @Override
    public BigDecimal withdrawCash(BigDecimal amount) {
        assertLogin();
        Card card = card();
        assertCardBlocked(card);
        if (card.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Not enough balance to withdraw");
        }
        BigDecimal balance = card.getBalance().min(amount);
        card.setBalance(balance);
        cardRepository.save(card);
        return balance;
    }

    private Card card() {
        return cardRepository.findByCardNumber(cardNumber);
    }

    private void assertLogin() {
        if (!loggedIn) {
            throw new IllegalStateException("No login");
        }
    }

    private void assertCardBlocked(Card card) {
        if (card.isBlocked()) {
            throw new IllegalStateException("Card [" + cardNumber + "] is blocked");
        }
    }
}
