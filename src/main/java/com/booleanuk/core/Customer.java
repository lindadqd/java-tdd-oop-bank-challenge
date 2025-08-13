package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Account> accounts;

    public Customer(){
        this.accounts = new ArrayList<>();
    }
    public boolean createAccount(String type) {
        String accountType = type.toUpperCase();
        if(accountType.equals("SAVINGS")){
            accounts.add(new Savings());
            return true;
        } else if (accountType.equals("CURRENT")) {
            accounts.add(new Current());
            return true;
        }
     return false;
    }
}
