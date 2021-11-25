package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Controller {
    private Account currentAccount;
    private Scanner scanner = new Scanner(System.in);
    private int choice = 0;

    public Controller() {
        currentAccount = new Account(123456789, 1234);
    }

    public void run() {
        consoleWelcomeText();
        pinChecking();
    }

    private void optionsDisplay() {
        String choice = "5";
        do {
            System.out.println("------------------------------");
            System.out.println("Options :");
            System.out.println("1 - Withdraw of money");
            System.out.println("2 - Deposit of money");
            System.out.println("3 - Transfer of money");
            System.out.println("4 - Change PIN code");
            System.out.println("5 - Exit");
            System.out.println("------------------------------");
            System.out.print("Choice : ");
            choice = scanner.next();
            choice.trim();
            handleOptions(choice);
        } while (choice == "5");
    }

    private void handleOptions(String choice) {
        switch (choice) {
            case "1":
                System.out.println("------------------------");
                System.out.println("WITHDRAW OF MONEY");
                System.out.println("------------------------");
                break;
            case "2":
                System.out.println("------------------------");
                System.out.println("DEPOSIT OF MONEY");
                System.out.println("------------------------");
                break;

            case "3":
                System.out.println("------------------------");
                System.out.println("TRANSFER OF MONEY");
                System.out.println("------------------------");
                break;
            case "4":
                System.out.println("------------------------");
                System.out.println("CHANGE PIN CODE");
                System.out.println("------------------------");
                break;
            case "5":
                System.out.println("------------------------");
                System.out.println("EXIT");
                System.out.println("------------------------");
                break;
            default:
                System.out.println("Type Something like 1, 2 ...");
                break;
        }
    }

    private void pinChecking() {
        int pinEntered = 0;
        do {
            System.out.println("Please insert your PIN");
            pinEntered = scanner.nextInt();
            System.out.println("Checking ...");
            if (pinEntered == currentAccount.getPIN()) {
                System.out.println("Correct PIN");
                break;
            }
        } while (pinEntered != currentAccount.getPIN());
        optionsDisplay();
    }

    private void consoleWelcomeText() {
        System.out.println("**************************************");
        System.out.println("Welcome at ATM machine");
        System.out.println("**************************************");
        System.out.println("ATM Card insertion ...");
        System.out.println("Success");
        System.out.println("**************************************");
        System.out.println("Your account Id is " + currentAccount.getId());
    }
}
