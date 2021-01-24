package com.example.Atm2;

public interface DispenseTopUpChain {

    void setNextChain(DispenseTopUpChain nextChain);

    void dispense(Currency cur, int amount);

    void topUp(Currency cur, int amount);
}