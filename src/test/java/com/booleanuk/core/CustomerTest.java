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

    @Test
    public void withdrawFundsOk(){
        Customer customer1 = new Customer();
        customer1.createAccount("savings");
        customer1.createAccount("current");
        customer1.depositFunds(1, 100);

        Assertions.assertTrue(customer1.withdrawFunds(1, 10));
        Assertions.assertTrue(customer1.withdrawFunds(1, 20));
        Assertions.assertTrue(customer1.withdrawFunds(1, 40));
        Assertions.assertTrue(customer1.withdrawFunds(1, 1));
    }

    @Test
    public void withdrawFundsNotOk(){
        Customer customer = new Customer();
        customer.createAccount("savings");

        Assertions.assertFalse(customer.withdrawFunds(0,100));
        customer.depositFunds(0, 100);
        Assertions.assertFalse(customer.withdrawFunds(0,101));
    }

}
