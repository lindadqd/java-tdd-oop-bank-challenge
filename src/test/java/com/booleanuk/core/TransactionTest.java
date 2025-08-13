package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TransactionTest {

    @Test
    public void generateStatement(){
        Transaction transaction = new Transaction(LocalDate.now(), 100, 10, "credit");
        String date = String.valueOf(LocalDate.now());
        String content = transaction.generateStatement();

        Assertions.assertTrue(content.contains(date));
        Assertions.assertTrue(content.contains("10"));;
        Assertions.assertTrue(content.contains("100"));
        Assertions.assertTrue(content.contains("credit"));;
    }
}
