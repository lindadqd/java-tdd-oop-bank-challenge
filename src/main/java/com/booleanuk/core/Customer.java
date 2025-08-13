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


    public boolean depositFunds(int accountId, float amount) {
        if (!accounts.isEmpty() && amount > 0) {
            for (Account account : accounts) {
                if (account.getId() == accountId) {
                    return account.depositFunds(amount);
                }
            }
        }
        return false;
    }

    public boolean withdrawFunds(int accountId, float amount) {
        if (!accounts.isEmpty() && amount > 0) {
            for (Account account : accounts) {
                if (account.getId() == accountId) {
                    return account.withdrawFunds(amount);
                }
            }
        }
        return false;
    }

    public String generateStatement(int accountId) {
        String transactions = String.format(" %-15s || %-15s || %-15s || %s " , "date", "credit", "debit", "balance");
        if(!accounts.isEmpty()){
            for(Account account: accounts){
                if (account.getId() == accountId){
                    transactions += account.generateStatement();
                }
            }
        } return transactions;

    }

    public List<Account> getAccounts(){
        return accounts;
    }
}
