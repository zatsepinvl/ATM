package com.effective.atm.impl;

import com.effective.atm.AtmLoginSession;
import com.effective.atm.AtmService;
import com.effective.atm.impl.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class AtmServiceImpl implements AtmService {

    private final CardRepository cardRepository;

    public AtmServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
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
    public AtmLoginSession enter(long cardNumber) {
        //ToDo
        throw new UnsupportedOperationException("tbd");
    }
}
