package org.example;

// Main.java
public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("111111", "Alice", 2000);
        BankAccount account2 = new BankAccount("222222", "Bob", 1000);

        System.out.println("Before transfer:");
        System.out.println(account1.getAccountHolder() + " balance: " + account1.getBalance());
        System.out.println(account2.getAccountHolder() + " balance: " + account2.getBalance());

        account1.transfer(account2, 500);

        System.out.println("\nAfter transfer:");
        System.out.println(account1.getAccountHolder() + " balance: " + account1.getBalance());
        System.out.println(account2.getAccountHolder() + " balance: " + account2.getBalance());
    }
}