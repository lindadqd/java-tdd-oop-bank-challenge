package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TransactionTest {

    @Test
    public void generateStatement(){
        Transaction transaction = new Transaction(LocalDate.now(), 100, 10, "credit");
        String date = String.valueOf(LocalDate.now());
        String content = String.valueOf(transaction.generateStatement());

        System.out.println(content);

        Assertions.assertTrue(content.contains(date));
        Assertions.assertTrue(content.contains("10.0"));;
        Assertions.assertTrue(content.contains("100.0"));
    }
}
