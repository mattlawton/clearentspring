package com.mattlawton.clearentspring.CreditCards;

public class Card {

    private double balance;
    public double getBalance() {
        return balance;
    }

    private double interestRate;
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    private String brand;
    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Card() {

    }

    public void adjustBalance(double amount) {

        this.balance += amount;
    }

}