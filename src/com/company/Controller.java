package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Controller {
    private Account currentAccount;
    private Scanner scanner = new Scanner(System.in);
    private int choice = 0;

    public Controller() {
        currentAccount = new Account(123456789, 1234, 1000000);
    }

    public void run() {
        consoleWelcomeText();
        pinChecking();
    }

    private void optionsDisplay() {
        String choice;
        do {
            System.out.println("------------------------------");
            System.out.println("Options :");
            System.out.println("1 - Withdraw of money");
            System.out.println("2 - Deposit of money");
            System.out.println("3 - Transfer of money");
            System.out.println("4 - Change PIN code");
            System.out.println("5 - Get your balance");
            System.out.println("6 - Exit");
            System.out.println("------------------------------");
            System.out.print("Choice : ");
            choice = scanner.next();
            choice = handleOptions(choice.trim());
        } while (choice == null);
    }

    private String handleOptions(String choice) {
        switch (choice) {
            case "1":
                System.out.println("------------------------");
                System.out.println("WITHDRAW OF MONEY");
                System.out.println("------------------------");
                withdrawMoney();
                break;
            case "2":
                System.out.println("------------------------");
                System.out.println("DEPOSIT OF MONEY");
                System.out.println("------------------------");
                depositMoney();
                break;

            case "3":
                System.out.println("------------------------");
                System.out.println("TRANSFER OF MONEY");
                System.out.println("------------------------");
                transferMoney();
                break;
            case "4":
                System.out.println("------------------------");
                System.out.println("CHANGE PIN CODE");
                System.out.println("------------------------");
                changePinCode();
                break;
            case "5":
                System.out.println("------------------------");
                System.out.println("YOUR BALANCE");
                System.out.println("------------------------");
                System.out.println("You have " + currentAccount.getBalance() + " XOF");
                break;
            case "6":
                System.out.println("------------------------");
                System.out.println("EXIT");
                System.out.println("------------------------");
                System.exit(0);
                break;
            default:
                System.out.println("Type Something like 1, 2 ...");
                break;
        }
        return null;
    }

    private void withdrawMoney() {
    }

    private void depositMoney() {
    }

    private void transferMoney() {
        System.out.println("Enter the cart number of the receiver:");
        int receiverId = scanner.nextInt();
        System.out.println("Enter the amount to transfer:");
        int amountToTransfer = scanner.nextInt();

        if (currentAccount.getBalance() >= amountToTransfer) {
            String yourChoice;
            do {
                System.out.println("Do you want to transfer " + amountToTransfer + " XOF to this account " + receiverId + " ? (Yes/No)");
                yourChoice = scanner.next();
                yourChoice = yourChoice.toLowerCase();
                if (yourChoice.trim().equals("yes")) {
                    System.out.println("Transfer succeed");
                    currentAccount.withdrawMoney(amountToTransfer);
                } else if (yourChoice.trim().equals("no")) {
                    System.out.println("Transfer aborted");
                } else {
                    yourChoice = "\n\0";
                }
            } while (yourChoice.equals("\n\0"));
        } else {
            System.out.println("Transfer impossible. Your account's balance is not enough");
        }
    }

    private void changePinCode() {
        System.out.println("Enter new pin code: ");
        int newPinCode = scanner.nextInt();
        System.out.println("Re-enter new pin code: ");
        int newPinCodeAgain = scanner.nextInt();
        if (newPinCode == newPinCodeAgain) {
            currentAccount.setPIN(newPinCodeAgain);
            System.out.println("PIN Code successfully updated");
        } else {
            System.out.println("Pin code is wrong");
        }
    }

    private void pinChecking() {
        int pinEntered;
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
