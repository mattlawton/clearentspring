package com.mattlawton.clearentspring.CreditCards;

public class Mastercard extends Card {

    public Mastercard(String name) {

        this.setBrand("mastercard");
        this.setInterestRate(.05);
        this.setName(name);
    }
}