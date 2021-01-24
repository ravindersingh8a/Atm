package com.example.ATM2;

public class Denomination {
    int count=0;
    int value=0;
    public Denomination(int value){
        this.value=value;
    }

    public void setCount(int count) {
        this.count = this.count + count;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
