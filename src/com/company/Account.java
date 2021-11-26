package com.company;

public class Account {
    private int id;
    private int PIN;
    private int balance;

    public Account(int id, int PIN, int balance) {
        this.id = id;
        this.PIN = PIN;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdrawMoney(int amount) {
        balance -= amount;
    }

    public void depositMoney(int amount) {
        balance += amount;
    }
}
