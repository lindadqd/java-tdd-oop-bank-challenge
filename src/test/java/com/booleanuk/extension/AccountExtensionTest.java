package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountExtensionTest {

    @Test
    public void calculateBalanceFromTransactions(){

        Account savings = new Savings();
        savings.depositFunds(100);
        savings.depositFunds(100);
        savings.depositFunds(100);
        savings.withdrawFunds(50);

        Assertions.assertEquals(250, savings.getBalance());
    }
}
