package com.effective.atm.impl.repository;

import com.effective.atm.impl.domain.Card;

import java.util.Optional;

public interface CardRepository {

    /**
     * @throws IllegalArgumentException if card isn't found
     */
    Card findByCardNumber(long cardNumber);

    Optional<Card> findByCardNumberIfExists(long cardNumber);

    void save(Card card);
}
