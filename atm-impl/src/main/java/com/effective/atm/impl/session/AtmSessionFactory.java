package com.effective.atm.impl.session;

import com.effective.atm.AtmSession;

public interface AtmSessionFactory {
    AtmSession newAtmSession(long cardNumber);
}
