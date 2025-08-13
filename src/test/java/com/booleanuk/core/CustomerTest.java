package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

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
        List<Account> accounts = customer.getAccounts();

        Assertions.assertTrue(customer.depositFunds(accounts.get(0).getId(), 100));
        Assertions.assertTrue(customer.depositFunds(accounts.get(1).getId(), 100000));
    }

    @Test
    public void depositFundsNotOk(){
        Customer customer = new Customer();
        customer.createAccount("savings");
        customer.createAccount("current");
        List<Account> accounts = customer.getAccounts();

        Assertions.assertFalse(customer.depositFunds(accounts.get(0).getId(), -100));
        Assertions.assertFalse(customer.depositFunds(accounts.get(1).getId(), 0));
    }

    @Test
    public void withdrawFunds(){
        Customer customer = new Customer();
        customer.createAccount("savings");
        List<Account> accounts = customer.getAccounts();

        customer.depositFunds(accounts.get(0).getId(),100);

        Assertions.assertTrue(customer.withdrawFunds(accounts.get(0).getId(), 10));
        Assertions.assertTrue(customer.withdrawFunds(accounts.get(0).getId(), 20));
        Assertions.assertTrue(customer.withdrawFunds(accounts.get(0).getId(), 40));
        Assertions.assertTrue(customer.withdrawFunds(accounts.get(0).getId(), 1));
    }

    @Test
    public void withdrawFundsNotOk(){
        Customer customer = new Customer();
        customer.createAccount("savings");
        List<Account> accounts = customer.getAccounts();

        Assertions.assertFalse(customer.withdrawFunds(accounts.get(0).getId(),100));
        customer.depositFunds(accounts.get(0).getId(), 100);
        Assertions.assertFalse(customer.withdrawFunds(accounts.get(0).getId(),101));
    }

    @Test
    public void generateStatement(){
        Customer customer = new Customer();
        customer.createAccount("savings");
        List<Account> accounts = customer.getAccounts();
        customer.depositFunds(accounts.get(0).getId(), 100);
        customer.withdrawFunds(accounts.get(0).getId(),10);

        String content = customer.generateStatement(accounts.get(0).getId());
        System.out.println(content);

        Assertions.assertTrue(content.contains("100.0"));
        Assertions.assertTrue(content.contains("10.0"));
        Assertions.assertTrue(content.contains("90.0"));
    }

    @Test
    public void generateStatement2(){
        Customer customer = new Customer();
        customer.createAccount("current");
        List<Account> accounts = customer.getAccounts();
        customer.depositFunds(accounts.get(0).getId(), 1000);
        customer.withdrawFunds(accounts.get(0).getId(),90);
        customer.withdrawFunds(accounts.get(0).getId(),10);
        customer.withdrawFunds(accounts.get(0).getId(),300);

        String content = customer.generateStatement(accounts.get(0).getId());
        System.out.println(content);

        Assertions.assertTrue(content.contains("1000.0"));
        Assertions.assertTrue(content.contains("10.0"));
        Assertions.assertTrue(content.contains("90.0"));
        Assertions.assertTrue(content.contains("300.0"));
        Assertions.assertTrue(content.contains(String.valueOf(LocalDate.now())));
    }
}
