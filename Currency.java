package com.example.ATM2;

public class Currency {

    private int amount = deno100.count * 100 + deno200.count * 200 + deno500.count * 500 + deno2000.count * 2000;
    private static final int INT_2000 = 2000;
    private static final int INT_500 = 500;
    private static final int INT_200 = 200;
    private static final int INT_100 = 100;

    private static Denomination deno2000 = new Denomination(INT_2000);
    private static Denomination deno500 = new Denomination(INT_500);
    private static Denomination deno200 = new Denomination(INT_200);
    private static Denomination deno100 = new Denomination(INT_100);

    public static Denomination getDeno2000() {
        return deno2000;
    }

    public static Denomination getDeno500() {
        return deno500;
    }

    public static Denomination getDeno200() {
        return deno200;
    }

    public static Denomination getDeno100() {
        return deno100;
    }

    public static int getAmount(){
        return deno100.count * 100 + deno200.count * 200 + deno500.count * 500 + deno2000.count * 2000;
    }
}