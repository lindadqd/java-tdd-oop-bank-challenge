package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomerExtensionTest {

    @Test
    public void requestOverDraftOk(){
        Customer customer = new Customer();
        customer.createAccount("current");
        List<Account> accounts = customer.getAccounts();
        Manager manager = new Manager();

        Assertions.assertTrue(customer.requestOverdraft(manager, accounts.get(0).getId(), 10 ));
        Assertions.assertTrue(customer.requestOverdraft(manager, accounts.get(0).getId(), 40 ));
        Assertions.assertTrue(customer.requestOverdraft(manager, accounts.get(0).getId(), 349 ));
    }

    @Test
    public void requestOverDraftNotOk(){
        Customer customer = new Customer();
        customer.createAccount("savings");
        customer.createAccount("current");
        List<Account> accounts = customer.getAccounts();
        Manager manager = new Manager();

        Assertions.assertFalse(customer.requestOverdraft(manager, accounts.get(0).getId(), 100));
        Assertions.assertFalse(customer.requestOverdraft(manager, accounts.get(1).getId(), 500));
    }
}
