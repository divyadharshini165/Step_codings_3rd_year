package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestInterfaceFactory {

    public static void main(String[] args) {

        System.out.println("=== Activity 12: Factory-Driven System Suite ===");

        // Test 1: Savings Account Creation & Deposit
        try {
            IAccount savings = AccountFactory.createAccount(
                    "SAVINGS", "SAV1001", "Rajesh Sharma",
                    28, 5000.0, "ACTIVE", "1234"
            );

            savings.deposit(1000.0);

            if (savings.getBalance() == 6000.0) {
                System.out.println("[Test 1] Savings Account Creation & Deposit: [PASS]");
            } else {
                System.out.println("[Test 1] Savings Account Creation & Deposit: [FAIL]");
            }

        } catch (Exception e) {
            System.out.println("[Test 1] Savings Account Creation & Deposit: [FAIL]");
        }


        // Test 2: Current Account Overdraft Withdrawal
        try {
            IAccount current = AccountFactory.createAccount(
                    "CURRENT", "CUR1001", "Priya Patel",
                    34, 10000.0, "ACTIVE", "5678"
            );

            current.withdraw(20000.0, "5678");

            if (current.getBalance() == -10000.0) {
                System.out.println("[Test 2] Current Account Overdraft Withdrawal: [PASS]");
            } else {
                System.out.println("[Test 2] Current Account Overdraft Withdrawal: [FAIL]");
            }

        } catch (Exception e) {
            System.out.println("[Test 2] Current Account Overdraft Withdrawal: [FAIL]");
        }


        // Test 3: Fixed Deposit Premature Withdrawal Block
        try {
            IAccount fixedDeposit = AccountFactory.createAccount(
                    "FIXED_DEPOSIT", "FD1001", "Amit Kumar",
                    45, 50000.0, "ACTIVE", "1111"
            );

            fixedDeposit.withdraw(10000.0, "1111");

            System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [FAIL]");

        } catch (AccountException e) {
            System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [PASS]");

        } catch (Exception e) {
            System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [FAIL]");
        }


        // Test 4: Invalid Account Type
        try {
            AccountFactory.createAccount(
                    "INVALID", "INV1001", "Test User",
                    30, 5000.0, "ACTIVE", "1234"
            );

            System.out.println("[Test 4] Invalid Type Rejection: [FAIL]");

        } catch (IllegalArgumentException e) {
            System.out.println("[Test 4] Invalid Type Rejection: [PASS]");
        }


        System.out.println("Factory-driven architecture successfully verified!");
    }
}