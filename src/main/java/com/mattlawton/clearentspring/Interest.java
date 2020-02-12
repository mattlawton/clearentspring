package com.mattlawton.clearentspring;

import com.mattlawton.clearentspring.CreditCards.Card;

import java.util.ArrayList;
import java.util.List;

public class Interest {

    // get a list of all interests for a person
    public static List getInterest(Person person) {
        List<Double> interests = new ArrayList<>();
        for (Wallet w : person.getWallets()) {
            for(Card c : w.getCards())
                interests.add(c.getInterestRate() * c.getBalance());
        }

        return interests;
    }

    // get individual interests for a person's specific wallet
    public static List getWalletInterest(Person person, String name) {
        List<Double> interests = new ArrayList<>();
        for (Card c : person.getWalletByName(name).getCards())
            interests.add(c.getInterestRate() * c.getBalance());

        return interests;
    }

    // get the total interest for a person's specific wallet
    public static double getWalletTotalInterest(Person person, String name) {
        double total = 0;
        for(Card c : person.getWalletByName(name).getCards())
            total += c.getInterestRate() * c.getBalance();

        return total;
    }

    // get the total interest for a person for all their wallets
    public static double getTotalInterest(Person person) {
        double total = 0;
        for (Wallet w : person.getWallets()) {
            for(Card c : w.getCards())
                total += c.getInterestRate() * c.getBalance();
        }

        return total;
    }
}