/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author suzuc
 */
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public synchronized void receiveCard(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getRank().equalsIgnoreCase("Ace")) {
                ++numAces;
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            --numAces;
        }

        return value;
    }

    public void displayHand() {
        System.out.println("Hand for " + name + ":");
        for (Card card : hand) {
            System.out.println(card);
        }
        System.out.println("Total value: " + getHandValue());
        System.out.println();
    }
}

