package com.example.ATM2;

public class Rupee200DispenseTopUp implements DispenseTopUpChain {

    private DispenseTopUpChain chain;

    @Override
    public void setNextChain(DispenseTopUpChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if(amount >= 200 && Currency.getAmount() >= amount){
            int num = (amount/Currency.getDeno200().value > Currency.getDeno200().count)
                    ?   Currency.getDeno200().count : amount/Currency.getDeno200().value;
            if(Currency.getDeno200().count >= num && num !=0) {
                System.out.println("Dispensing " + num + " Rs. 200 note");
                Currency.getDeno200().setCount(-1 * num);
                int remainder = amount - (num * Currency.getDeno200().value);
                if (remainder != 0) this.chain.dispense(remainder);
            }
        } else {
            this.chain.dispense(amount);
        }
    }

    @Override
    public void topUp( int amount) {
        if(amount >= 200){
            int num = amount / Currency.getDeno200().value;
            Currency.getDeno200().setCount(num);
            int remainder = amount - (num * Currency.getDeno200().value);
            if (remainder != 0) this.chain.dispense(remainder);
        } else {
            this.chain.dispense(amount);
        }
    }
}
