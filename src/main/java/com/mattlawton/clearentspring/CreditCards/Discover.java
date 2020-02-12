package com.mattlawton.clearentspring.CreditCards;

public class Discover extends Card {

    public Discover(String name) {

        this.setBrand("discover");
        this.setInterestRate(.01);
        this.setName(name);
    }
}