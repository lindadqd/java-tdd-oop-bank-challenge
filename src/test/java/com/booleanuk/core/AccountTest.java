package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void depositFundsOk(){
        Account savings = new Savings();
        Account current = new Current();

        Assertions.assertTrue(savings.depositFunds(100));
        Assertions.assertTrue(savings.depositFunds(1 ));
        Assertions.assertTrue(savings.depositFunds(100.10F));
        Assertions.assertTrue(current.depositFunds(100));
        Assertions.assertTrue(current.depositFunds(1235678));
        Assertions.assertTrue(current.depositFunds(100.10F));
    }

    @Test
    public void depositFundsNotOk(){
        Account current = new Current();
        Account savings = new Savings();

        Assertions.assertFalse(current.depositFunds(0));
        Assertions.assertFalse(current.depositFunds(-10));
        Assertions.assertFalse(current.depositFunds(-1));
        Assertions.assertFalse(savings.depositFunds(0));
        Assertions.assertFalse(savings.depositFunds(-10));
        Assertions.assertFalse(savings.depositFunds(-1));


    }
}
