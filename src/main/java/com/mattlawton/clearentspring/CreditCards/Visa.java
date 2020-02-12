package com.mattlawton.clearentspring.CreditCards;

public class Visa extends Card {

    public Visa(String name) {
        this.setBrand("visa");
        this.setInterestRate(.1);
        this.setName(name);
    }

}