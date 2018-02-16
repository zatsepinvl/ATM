package com.effective.atm.impl.repository;

import com.effective.atm.impl.domain.Card;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository {
    @Override
    public Card findByCardNumber(long cardNumber) {
        //ToDo
        throw new UnsupportedOperationException("tbd");
    }

    @Override
    public Optional<Card> findByCardNumberIfExists(long cardNumber) {
        //ToDo
        throw new UnsupportedOperationException("tbd");
    }

    @Override
    public void save(Card card) {
        //ToDo
        throw new UnsupportedOperationException("tbd");
    }
}
