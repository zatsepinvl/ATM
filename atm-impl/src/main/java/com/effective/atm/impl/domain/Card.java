package com.effective.atm.impl.domain;

import java.math.BigDecimal;

import static java.lang.String.valueOf;
import static org.mindrot.jbcrypt.BCrypt.*;

public class Card {
    private long id;
    private long cardNumber;
    private boolean blocked;
    private String pin;
    private BigDecimal balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean checkPin(int pin) {
        return checkpw(String.valueOf(pin), this.pin);
    }

    public String getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = hashpw(valueOf(pin), gensalt());
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
