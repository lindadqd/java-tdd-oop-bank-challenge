package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private float balance;
    private List<Transaction> transactions;
    private static int nextId = 0;
    private int accountId;

    public Account(){
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.accountId = nextId++;
    }

    public boolean depositFunds(float amount) {
        if (amount > 0){
            balance += amount;
            transactions.add(new Transaction(LocalDate.now(),this.balance, amount, "credit"));
            return true;
        } return false;
    }

    public int getId() {
        return this.accountId;
    }

    public Boolean withdrawFunds(float amount) {
        return null;
    }
}
