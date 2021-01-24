package com.example.ATM2;

public interface DispenseTopUpChain {

    void setNextChain(DispenseTopUpChain nextChain);

    void dispense(int amount);

    void topUp(int amount);
}