package com.mattlawton.clearentspring;

import com.mattlawton.clearentspring.CreditCards.Discover;
import com.mattlawton.clearentspring.CreditCards.Mastercard;
import com.mattlawton.clearentspring.CreditCards.Visa;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClearentspringApplicationTests {

    /* 1 person has 1 wallet and 3 cards (1 Visa, 1 MC 1 Discover) – Each Card has a balance of $100 –
    calculate the total interest (simple interest) for this person and per card. */
    @Test
    public void Test_1_Wallet_3_Cards() {

        Person person = new Person();

        person.addWallet("Wallet 1");

        person.getWalletByName("Wallet 1").addCard(new Visa("visa 1"));
        person.getWalletByName("Wallet 1").addCard(new Mastercard("mastercard 1"));
        person.getWalletByName("Wallet 1").addCard(new Discover("discover 1"));

        person.getWalletByName("Wallet 1").getCardByName("visa 1").adjustBalance(100);
        person.getWalletByName("Wallet 1").getCardByName("mastercard 1").adjustBalance(100);
        person.getWalletByName("Wallet 1").getCardByName("discover 1").adjustBalance(100);

        List<Double> expected = Arrays.asList(10.0, 5.0, 1.0);
        assert(expected.containsAll(Interest.getInterest(person)));
        assert(expected.size() == Interest.getWalletInterest(person, "Wallet 1").size());

        assertEquals(16, Interest.getTotalInterest(person));

    }

    /*	1 person has 2 wallets  Wallet 1 has a Visa and Discover , wallet 2 a MC -
     each card has $100 balance - calculate the total interest(simple interest) for this person and interest per wallet */
    @Test
    public void Test_2_Wallets_3_Cards() {

        Person person = new Person();

        person.addWallet("Wallet 1");
        person.getWalletByName("Wallet 1").addCard(new Visa("visa 1"));
        person.getWalletByName("Wallet 1").addCard(new Discover("discover 1"));
        person.getWalletByName("Wallet 1").getCardByName("visa 1").adjustBalance(100);
        person.getWalletByName("Wallet 1").getCardByName("discover 1").adjustBalance(100);

        person.addWallet("Wallet 2");
        person.getWalletByName("Wallet 2").addCard(new Mastercard("mastercard 1"));
        person.getWalletByName("Wallet 2").getCardByName("mastercard 1").adjustBalance(100);


        assertEquals(16, Interest.getTotalInterest(person));

        assertEquals(11, Interest.getWalletTotalInterest(person, "Wallet 1"));

        assertEquals(5, Interest.getWalletTotalInterest(person,"Wallet 2"));

        List<Double> expected = Arrays.asList(10.0, 1.0);
        assert(expected.containsAll(Interest.getWalletInterest(person,"Wallet 1")));
        assert(expected.size() == Interest.getWalletInterest(person,"Wallet 1").size());

        List<Double> expected2 = Arrays.asList(5.0);
        assert(expected2.containsAll(Interest.getWalletInterest(person, "Wallet 2")));
        assert(expected2.size() == Interest.getWalletInterest(person, "Wallet 2").size());

    }


    /*	2 people have 1 wallet each,  person 1 has 1 wallet , with 2 cards MC and visa person 2 has 1 wallet –
     1 visa and 1 MC -
     each card has $100 balance - calculate the total interest(simple interest) for each person and interest per wallet */
    @Test
    public void Test_2_People_1_Wallet_4_Cards() {

        Person first = new Person();
        Person second = new Person();

        first.addWallet("Wallet 1");
        second.addWallet("Wallet 1");

        first.getWalletByName("Wallet 1").addCard(new Mastercard("mastercard 1"));
        first.getWalletByName("Wallet 1").addCard(new Mastercard("mastercard 2"));

        second.getWalletByName("Wallet 1").addCard(new Visa("visa 1"));
        second.getWalletByName("Wallet 1").addCard(new Mastercard("mastercard 1"));

        first.getWalletByName("Wallet 1").getCardByName("mastercard 1").adjustBalance(100);
        first.getWalletByName("Wallet 1").getCardByName("mastercard 2").adjustBalance(100);

        second.getWalletByName("Wallet 1").getCardByName("visa 1").adjustBalance(100);
        second.getWalletByName("Wallet 1").getCardByName("mastercard 1").adjustBalance(100);

        assertEquals(10, Interest.getTotalInterest(first));

        assertEquals(15, Interest.getTotalInterest(second));

        assertEquals(10, Interest.getWalletTotalInterest(first, "Wallet 1"));

        assertEquals(15, Interest.getWalletTotalInterest(second,"Wallet 1"));

        List<Double> expected = Arrays.asList(5.0, 5.0);
        assert(expected.containsAll(Interest.getInterest(first)));
        assert(expected.size() == Interest.getInterest(first).size());

        List<Double> expected2 = Arrays.asList(10.0, 5.0);
        assert(expected2.containsAll(Interest.getInterest(second)));
        assert(expected2.size() == Interest.getInterest(second).size());

    }


}
