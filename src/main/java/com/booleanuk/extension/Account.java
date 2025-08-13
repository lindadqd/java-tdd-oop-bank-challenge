package com.booleanuk.extension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private float balance;
    private List<Transaction> transactions;
    private static int nextId = 0;
    private int accountId;
    private String branch;
    private boolean canOverdraft;

    public Account(){
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.accountId = nextId++;
        this.canOverdraft = false;
    }

    public boolean depositFunds(float amount) {
        if (amount > 0){
            this.balance += amount;
            transactions.add(new Transaction(LocalDate.now(),this.balance, amount, "credit"));
            return true;
        } return false;
    }

    public int getId() {
        return this.accountId;
    }

    public boolean withdrawFunds(float amount) {
        if (amount > 0 && amount <= this.balance){
            this.balance -= amount;
            transactions.add(new Transaction(LocalDate.now(),this.balance, amount, "debit"));
            return true;
        } return false;
    }

    public String generateStatement() {
        String transactionStrings = "";
        for(Transaction transaction : transactions){
            transactionStrings += transaction.generateStatement();
        }
        return transactionStrings;
    }

    public float getBalance(){
        float sum = 0;
        if (!transactions.isEmpty()){
            for(Transaction transaction: transactions){
                if(transaction.getType().equals("credit")){
                    sum += transaction.getAmount();
                } else sum -= transaction.getAmount();
            }
        } return sum;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean isCanOverdraft() {
        return canOverdraft;
    }

    public void setCanOverdraft(boolean canOverdraft) {
        this.canOverdraft = canOverdraft;
    }
}
