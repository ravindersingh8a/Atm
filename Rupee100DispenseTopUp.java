package com.example.ATM2;

public class Rupee100DispenseTopUp implements DispenseTopUpChain {

    private DispenseTopUpChain chain;

    @Override
    public void setNextChain(DispenseTopUpChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if(amount >= 100 && Currency.getAmount() >= amount && Currency.getDeno100().count>0){
            int num = (amount/Currency.getDeno100().value > Currency.getDeno100().count)
                    ?   Currency.getDeno100().count : amount/Currency.getDeno100().value;
            if(Currency.getDeno100().count >= num && num !=0) {
                System.out.println("Dispensing " + num + " Rs. 100 note");
                Currency.getDeno100().setCount(-1 * num);
                int remainder = amount - (num * Currency.getDeno100().value);
                if (remainder != 0) System.out.println("Insufficient Amount"); //this.chain.dispense(remainder);
            }
        } else {
            System.out.println("Insufficient Amount");
           // this.chain.dispense(amount);
        }
    }

    @Override
    public void topUp(int amount) {
        if(amount >= 100){
            int num = amount / Currency.getDeno100().value;
            Currency.getDeno100().setCount(num);
            int remainder = amount - (num * Currency.getDeno100().value);
            if (remainder != 0) this.chain.dispense(remainder);
        } else {
            this.chain.dispense(amount);
        }
    }
}
