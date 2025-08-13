package com.booleanuk.extension;

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

    public String generateStatement() {
       String transaction = "";
        if (this.type.equals("credit")) {
            transaction += "\n" + (String.format(" %-15s || %-15s || %-15s || %s " , String.valueOf(this.date) , this.amount, " ", this.balance ));
        } else {
            transaction += "\n" + (String.format(" %-15s || %-15s || %-15s || %s " , String.valueOf(this.date) , " ", this.amount, this.balance ));        }
        return transaction;
    }

    public String getType() {
        return this.type;
    }
}
