package com.example.Atm2;

public class Rupee100DispenseTopUp implements DispenseTopUpChain {

    private DispenseTopUpChain chain;

    @Override
    public void setNextChain(DispenseTopUpChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur, int amount) {
        if(amount >= 100 && cur.getAmount() >= amount){
            int num = (amount/Currency.getDeno100().value > Currency.getDeno100().count)
                    ?   Currency.getDeno100().count : amount/Currency.getDeno100().value;
            if(Currency.getDeno100().count >= num && num !=0) {
                System.out.println("Dispensing " + num + " Rs. 100 note");
                Currency.getDeno100().setCount(-1 * num);
                int remainder = amount - (num * Currency.getDeno100().value);
                if (remainder != 0) this.chain.dispense(cur, remainder);
            }
        } else {
            this.chain.dispense(cur,amount);
        }
    }

    @Override
    public void topUp(Currency cur, int amount) {
        if(amount >= 100){
            int num = amount / Currency.getDeno100().value;
            Currency.getDeno100().setCount(num);
            int remainder = amount - (num * Currency.getDeno100().value);
            if (remainder != 0) this.chain.dispense(cur, remainder);
        } else {
            this.chain.dispense(cur,amount);
        }
    }
}
