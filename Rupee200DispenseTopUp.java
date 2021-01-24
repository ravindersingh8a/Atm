package com.example.Atm2;

public class Rupee200DispenseTopUp implements DispenseTopUpChain {

    private DispenseTopUpChain chain;

    @Override
    public void setNextChain(DispenseTopUpChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur, int amount) {
        if(amount >= 200 && cur.getAmount() >= amount){
            int num = (amount/Currency.getDeno200().value > Currency.getDeno200().count)
                    ?   Currency.getDeno200().count : amount/Currency.getDeno200().value;
            if(Currency.getDeno200().count >= num && num !=0) {
                System.out.println("Dispensing " + num + " Rs. 200 note");
                Currency.getDeno200().setCount(-1 * num);
                int remainder = amount - (num * Currency.getDeno200().value);
                if (remainder != 0) this.chain.dispense(cur, remainder);
            }
        } else {
            this.chain.dispense(cur,amount);
        }
    }

    @Override
    public void topUp(Currency cur, int amount) {
        if(amount >= 200){
            int num = amount / Currency.getDeno200().value;
            Currency.getDeno200().setCount(num);
            int remainder = amount - (num * Currency.getDeno200().value);
            if (remainder != 0) this.chain.dispense(cur, remainder);
        } else {
            this.chain.dispense(cur,amount);
        }
    }
}
