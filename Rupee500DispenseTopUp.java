package com.example.ATM2;

public class Rupee500DispenseTopUp implements DispenseTopUpChain {

    private DispenseTopUpChain chain;

    @Override
    public void setNextChain(DispenseTopUpChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if(amount >= 500 && Currency.getAmount() >= amount && Currency.getDeno500().count>0){
            int num = (amount/Currency.getDeno500().value > Currency.getDeno500().count)
                    ?   Currency.getDeno500().count : amount/Currency.getDeno500().value;
            if(Currency.getDeno500().count >= num && num !=0) {
                System.out.println("Dispensing " + num + " Rs. 500 note");
                Currency.getDeno500().setCount(-1 * num);
                int remainder = amount - (num * Currency.getDeno500().value);
                if (remainder != 0) this.chain.dispense(remainder);
            }
        } else {
            this.chain.dispense(amount);
        }
    }

    @Override
    public void topUp(int amount) {
        if(amount >= 500){
            int num = amount / Currency.getDeno500().value;
            Currency.getDeno500().setCount(num);
            int remainder = amount - (num * Currency.getDeno500().value);
            if (remainder != 0) this.chain.dispense(remainder);
        } else {
            this.chain.dispense(amount);
        }
    }
}
