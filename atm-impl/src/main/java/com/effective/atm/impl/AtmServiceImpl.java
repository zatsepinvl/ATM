package com.effective.atm.impl;

import com.effective.atm.AtmService;
import com.effective.atm.AtmSession;
import com.effective.atm.impl.repository.CardRepository;
import com.effective.atm.impl.session.AtmSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtmServiceImpl implements AtmService {

    private final CardRepository cardRepository;
    private final AtmSessionFactory atmSessionFactory;

    public AtmServiceImpl(
            CardRepository cardRepository,
            AtmSessionFactory atmSessionFactory
    ) {
        this.cardRepository = cardRepository;
        this.atmSessionFactory = atmSessionFactory;
    }

    @Override
    public boolean isCardExists(long cardNumber) {
        return cardRepository.findByCardNumberIfExists(cardNumber).isPresent();
    }

    @Override
    public boolean isCardBlocked(long cardNumber) {
        return cardRepository.findByCardNumber(cardNumber).isBlocked();
    }

    @Override
    public AtmSession enter(long cardNumber) {
        if (!cardRepository.findByCardNumberIfExists(cardNumber).isPresent()) {
            throw new IllegalArgumentException("Card [" + cardNumber + "] not found");
        }
        return atmSessionFactory.newAtmSession(cardNumber);
    }
}
