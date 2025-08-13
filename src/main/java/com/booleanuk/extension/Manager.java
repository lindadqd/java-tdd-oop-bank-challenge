package com.booleanuk.extension;


public class Manager {

    public Boolean requestOverdraft(Account account, float amount) {
        if(account instanceof Savings){
            return false;
        }
        if (account.getBalance() - amount  <= -500){
            return false;
        }  account.withdrawFundsOverdraft(this, amount);
        return true;
    }
}
