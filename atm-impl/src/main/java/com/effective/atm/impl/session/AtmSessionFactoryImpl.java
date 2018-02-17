package com.effective.atm.impl.session;

import com.effective.atm.AtmSession;
import com.effective.atm.impl.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class AtmSessionFactoryImpl implements AtmSessionFactory {

    private final CardRepository cardRepository;

    public AtmSessionFactoryImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public AtmSession newAtmSession(long cardNumber) {
        return new AtmSessionImpl(cardRepository, cardNumber);
    }
}
