package com.effective.atm.impl.repository;

import com.effective.atm.impl.domain.Card;

import java.util.Optional;

public class CardRepositoryImpl implements CardRepository {
    @Override
    public Card getByCardNumber(long cardNumber) {
        //ToDo
        throw new UnsupportedOperationException("tbd");
    }

    @Override
    public Optional<Card> findByCardNumber(long cardNumber) {
        //ToDo
        throw new UnsupportedOperationException("tbd");
    }

    @Override
    public void save(Card card) {
        //ToDo
        throw new UnsupportedOperationException("tbd");
    }
}
