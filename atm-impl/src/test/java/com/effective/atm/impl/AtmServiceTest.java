package com.effective.atm.impl;

import com.effective.atm.AtmService;
import com.effective.atm.impl.domain.Card;
import com.effective.atm.impl.domain.CardBuilder;
import com.effective.atm.impl.repository.CardRepository;
import com.effective.atm.impl.session.AtmSessionFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AtmServiceTest {

    private static final long CARD_NUMBER = 1111_2222_3333_4444L;
    private static final long CARD_NOT_EXISTS_NUMBER = 5555_5555_5555_5555L;
    private static final long CARD_BLOCKED_NUMBER = 6666_6666_6666_6666L;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    private CardRepository cardRepository;

    @Mock
    private AtmSessionFactory atmSessionFactory;

    private AtmService atmService;

    @Before
    public void setUp() {
        atmService = new AtmServiceImpl(cardRepository, atmSessionFactory);
    }

    @Test
    public void card_exists() {
        when(cardRepository.findByCardNumberIfExists(CARD_NUMBER)).thenReturn(Optional.of(new Card()));
        when(cardRepository.findByCardNumberIfExists(CARD_NOT_EXISTS_NUMBER)).thenReturn(Optional.empty());

        assertTrue(atmService.isCardExists(CARD_NUMBER));
        assertFalse(atmService.isCardExists(CARD_NOT_EXISTS_NUMBER));
    }

    @Test
    public void card_blocked() {
        Card card = new CardBuilder()
                .cardNumber(CARD_NUMBER)
                .build();
        when(cardRepository.findByCardNumber(CARD_NUMBER)).thenReturn(card);

        Card blockedCard = new CardBuilder()
                .cardNumber(CARD_BLOCKED_NUMBER)
                .blocked(true)
                .build();
        when(cardRepository.findByCardNumber(CARD_BLOCKED_NUMBER)).thenReturn(blockedCard);

        assertFalse(atmService.isCardBlocked(CARD_NUMBER));
        assertTrue(atmService.isCardBlocked(CARD_BLOCKED_NUMBER));
    }

    @Test
    public void card_blocked_exception() {
        when(cardRepository.findByCardNumber(CARD_NOT_EXISTS_NUMBER)).thenThrow(IllegalArgumentException.class);
        exception.expect(IllegalArgumentException.class);

        atmService.isCardBlocked(CARD_NOT_EXISTS_NUMBER);
    }

}
