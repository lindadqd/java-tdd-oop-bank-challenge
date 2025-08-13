package com.booleanuk.core;

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
}
