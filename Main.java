package com.example.ATM2;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        AmountDispenseTopUpChain atm = new AmountDispenseTopUpChain();
        DispenseTopUpChain dispenseTopupChain = atm.getChainStart();
        while(true) {
            System.out.println("-------Main Menu-------\n" +
                    "1.TOP UP\n" +
                    "2.Withdraw Cash\n" +
                    "3.Check Balance\n" +
                    "4.End Transaction\n");
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();

            if (a == 1) {
                System.out.println("Choose Currency:\n" +
                        "1. 100 Rs\n" +
                        "2. 200 Rs\n" +
                        "3. 500 Rs.\n" +
                        "4. 2000 Rs.\n" +
                        "5. Deposit Any Amount.\n");

                int b = scanner.nextInt();

                if (b == 1) {
                    System.out.println("Enter no. of Notes");
                    int c = scanner.nextInt();
                    Currency.getDeno100().setCount(c);
                    System.out.println("Balance:" + Currency.getAmount());
                } else if (b == 2) {
                    System.out.println("Enter no. of Notes");
                    int c = scanner.nextInt();
                    Currency.getDeno200().setCount(c);
                    System.out.println("Balance:" + Currency.getAmount());
                } else if (b == 3) {
                    System.out.println("Enter no. of Notes");
                    int c = scanner.nextInt();
                    Currency.getDeno500().setCount(c);
                    System.out.println("Balance:" + Currency.getAmount());
                } else if (b == 4) {
                    System.out.println("Enter no. of Notes");
                    int c = scanner.nextInt();
                    Currency.getDeno2000().setCount(c);
                    System.out.println("Balance:" + Currency.getAmount());
                } else if (b == 5) {
                    System.out.println("Please enter amount to topUp Cash");
                    int amount = scanner.nextInt();
                    if (amount % 100 != 0) {
                        System.out.println("Please Enter the amount in multiple of 100");
                        amount = scanner.nextInt();
                    }
                    dispenseTopupChain.topUp(amount);
                } else {
                    System.out.println("Choose Correct Option!");
                }
            } else if (a == 2) {
                System.out.println("Please enter amount to withdraw Cash");
                int amount = scanner.nextInt();
                if (amount % 100 != 0) {
                    System.out.println("Please Enter the amount in multiple of 100");
                    amount = scanner.nextInt();
                }
                dispenseTopupChain.dispense(amount);
            } else if (a == 3) {
                System.out.println("Balance:" + Currency.getAmount());
            } else if (a == 4) {
                    break;
            } else {
                System.out.println("Choose Correct Option!");
            }
        }
    }

}