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

}
