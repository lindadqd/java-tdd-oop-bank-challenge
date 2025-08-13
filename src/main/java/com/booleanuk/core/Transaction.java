package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private float balance;
    private float amount;
    private String type;

    public Transaction(LocalDate now, float balance, float amount, String type) {
        this.date = now;
        this.balance = balance;
        this.amount = amount;
        this.type = type;
    }
}
