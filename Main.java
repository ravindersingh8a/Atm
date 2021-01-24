package com.example.Atm2;

import java.security.PublicKey;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {

        System.out.println("-------Main Menu-------\n" +
                "1.TOP UP\n" +
                "2.Withdraw Cash\n" +
                "3.Check Balance\n"+
                "4.End Transaction\n");
        Scanner scanner =new Scanner(System.in);
        int a = scanner.nextInt();

        if (a==1)
        {
            System.out.println("Choose Currency:\n" +
                    "1. 100 Rs"+
                    "2. 200 Rs\n" +
                    "3. 500 Rs.\n" +
                    "4. 1000 Rs.\n" +
                    "5. 2000 Rs.\n");

             int b= scanner.nextInt();

             if(a==1)
             {
                 System.out.println("Enter no. of Notes");
                 int c = scanner.nextInt();
                 Currency.getDeno100().setCount(c);
               System.out.println("Balance:"+Currency.getAmount());
             }
             else if(a==2)
             {
                 System.out.println("Enter no. of Notes");
                 int c = scanner.nextInt();
                 Currency.getDeno200().setCount(c);
                 System.out.println("Balance:"+Currency.getAmount());
             }
             else if(a==3)
             {
                 System.out.println("Enter no. of Notes");
                 int c = scanner.nextInt();
                 Currency.getDeno500().setCount(c);
                 System.out.println("Balance:"+Currency.getAmount());
             }

             else if(a==4)
             {
                 System.out.println("Enter no. of Notes");
                 int c = scanner.nextInt();
                 Currency.getDeno2000().setCount(c);
                 System.out.println("Balance:"+Currency.getAmount());
             }
             else {
                 System.out.println("Choose Correct Option!");
             }

        }
        else if(a==2)
        {
            System.out.println("Please enter amount to withdraw Cash");
            int amount=scanner.nextInt();
           AmountDispenseTopUpChain atm = new AmountDispenseTopUpChain();
           DispenseTopUpChain dispenseChain = atm.getChainStart();
           Currency cur = new Currency();
           dispenseChain.dispense(cur,amount);

        }
        else if(a==3)
        {

        }

        else if(a==4)
        {

        }

        else {
            System.out.println("Choose Correct Option!");
        }

    }

}
