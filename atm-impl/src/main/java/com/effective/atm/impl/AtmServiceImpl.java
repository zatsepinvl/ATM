package com.effective.atm.impl;

import com.effective.atm.AtmLoginSession;
import com.effective.atm.AtmService;

public class AtmServiceImpl implements AtmService {
    @Override
    public boolean isCardExists(long cardNumber) {
        return false;
    }

    @Override
    public boolean isCardBlocked(long cardNumber) {
        return false;
    }

    @Override
    public AtmLoginSession enter(long cardNumber) {
        return null;
    }
}
