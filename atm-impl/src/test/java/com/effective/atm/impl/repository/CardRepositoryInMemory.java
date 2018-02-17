package com.effective.atm.impl.repository;

import com.effective.atm.impl.domain.Card;
import com.effective.atm.impl.repository.CardRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("in-memory")
@Primary
public class CardRepositoryInMemory implements CardRepository {

    private final Map<Long, Card> cards;

    public CardRepositoryInMemory() {
        cards = new HashMap<>();
    }

    @Override
    public Card findByCardNumber(long cardNumber) {
        return findByCardNumberIfExists(cardNumber)
                .orElseThrow(() -> new IllegalArgumentException("Card not found with number " + cardNumber));
    }

    @Override
    public Optional<Card> findByCardNumberIfExists(long cardNumber) {
        return Optional.ofNullable(cards.get(cardNumber));
    }

    @Override
    public void save(Card card) {
        cards.put(card.getCardNumber(), card);
    }
}
