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

    @Test
    public void withdrawFundsOk(){
        Account current = new Current();
        Account savings = new Savings();
        current.depositFunds(1000000000);
        savings.depositFunds(1000000000);

        Assertions.assertTrue(current.withdrawFunds(1));
        Assertions.assertTrue(current.withdrawFunds(5000));
        Assertions.assertTrue(current.withdrawFunds(1123423));
        Assertions.assertTrue(current.withdrawFunds(1.123F));
        Assertions.assertTrue(current.withdrawFunds(100F));
        Assertions.assertTrue(current.withdrawFunds(9876.1234F));
        Assertions.assertTrue(current.withdrawFunds(24));

        Assertions.assertTrue(savings.withdrawFunds(1));
        Assertions.assertTrue(savings.withdrawFunds(5000));
        Assertions.assertTrue(savings.withdrawFunds(1123423));
        Assertions.assertTrue(savings.withdrawFunds(1.123F));
        Assertions.assertTrue(savings.withdrawFunds(100F));
        Assertions.assertTrue(savings.withdrawFunds(9876.1234F));
        Assertions.assertTrue(savings.withdrawFunds(24));
    }

    @Test
    public void withdrawFundsNotOk(){
        Account current = new Current();
        Account savings = new Savings();

        Assertions.assertFalse(current.withdrawFunds(0));
        Assertions.assertFalse(current.withdrawFunds(-10));
        Assertions.assertFalse(savings.withdrawFunds(0));
        Assertions.assertFalse(current.withdrawFunds(-1));


    }
}
