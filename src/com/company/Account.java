package com.company;

public class Account {
    private int id;
    private int PIN;
    protected static int balance;

    public Account(int id, int PIN) {
        this.id = id;
        this.PIN = PIN;
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
}
