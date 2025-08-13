package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void createAccountOk(){
        Customer customer = new Customer();

        Assertions.assertTrue(customer.createAccount("savings"));
        Assertions.assertTrue(customer.createAccount("saViNgs"));
        Assertions.assertTrue(customer.createAccount("CURRENT"));
        Assertions.assertTrue(customer.createAccount("CUrrenT"));
    }

    @Test
    public void createAccountNotOk(){
        Customer customer = new Customer();

        Assertions.assertFalse(customer.createAccount(""));
        Assertions.assertFalse(customer.createAccount("something"));
        Assertions.assertFalse(customer.createAccount("!!"));
        Assertions.assertFalse(customer.createAccount("asdasda"));
        Assertions.assertFalse(customer.createAccount("123"));
    }

    @Test
    public void depositFundsOk(){
        Customer customer = new Customer();
        customer.createAccount("savings");
        customer.createAccount("current");

        Assertions.assertTrue(customer.depositFunds(0, 100));
        Assertions.assertTrue(customer.depositFunds(1, 100000));
    }

    @Test
    public void depositFundsNotOk(){
        Customer customer = new Customer();
        customer.createAccount("savings");
        customer.createAccount("current");
        Assertions.assertFalse(customer.depositFunds(0, -100));
        Assertions.assertFalse(customer.depositFunds(1, 0));
    }

}
