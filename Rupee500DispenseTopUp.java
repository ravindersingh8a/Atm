package com.example.Atm2;

public class Rupee500DispenseTopUp implements DispenseTopUpChain {

    private DispenseTopUpChain chain;

    @Override
    public void setNextChain(DispenseTopUpChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur, int amount) {
        if(amount >= 500 && cur.getAmount() >= amount){
            int num = (amount/Currency.getDeno500().value > Currency.getDeno500().count)
                    ?   Currency.getDeno500().count : amount/Currency.getDeno500().value;
            if(Currency.getDeno500().count >= num && num !=0) {
                System.out.println("Dispensing " + num + " Rs. 500 note");
                Currency.getDeno500().setCount(-1 * num);
                int remainder = amount - (num * Currency.getDeno500().value);
                if (remainder != 0) this.chain.dispense(cur, remainder);
            }
        } else {
            this.chain.dispense(cur,amount);
        }
    }

    @Override
    public void topUp(Currency cur, int amount) {
        if(amount >= 500){
            int num = amount / Currency.getDeno500().value;
            Currency.getDeno500().setCount(num);
            int remainder = amount - (num * Currency.getDeno500().value);
            if (remainder != 0) this.chain.dispense(cur, remainder);
        } else {
            this.chain.dispense(cur,amount);
        }
    }
}
