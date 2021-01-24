package com.example.Atm2;

public class Rupee2000DispenseTopUp implements DispenseTopUpChain {

    private DispenseTopUpChain chain;

    @Override
    public void setNextChain(DispenseTopUpChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur, int amount) {
        if(amount >= 2000 && cur.getAmount() >= amount){
            int num = (amount/Currency.getDeno2000().value > Currency.getDeno2000().count)
                        ?   Currency.getDeno2000().count : amount/Currency.getDeno2000().value;
            if(Currency.getDeno2000().count >= num && num !=0) {
                System.out.println("Dispensing " + num + " Rs. 2000 note");
                Currency.getDeno2000().setCount(-1 * num);
                int remainder = amount - (num * Currency.getDeno2000().value);
                if (remainder != 0) this.chain.dispense(cur, remainder);
            }
        } else {
            this.chain.dispense(cur,amount);
        }
    }

    @Override
    public void topUp(Currency cur, int amount) {
        if(amount >= 2000){
                int num = amount / Currency.getDeno2000().value;
                Currency.getDeno2000().setCount(num);
                int remainder = amount - (num * Currency.getDeno2000().value);
                if (remainder != 0) this.chain.dispense(cur, remainder);
        } else {
            this.chain.dispense(cur,amount);
        }
    }
}
