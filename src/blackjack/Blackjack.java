/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

/**
 *
 * @author suzuc
 

    /**
     * @param args the command line arguments
     */
    import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player("Player");
        Player dealer = new Player("Dealer");

        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());

        player.displayHand();
        dealer.displayHand();

        // Player's turn
        while (player.getHandValue() < 21) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to hit or stand? ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("hit")) {
                player.receiveCard(deck.drawCard());
                player.displayHand();
            } else if (choice.equals("stand")) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'hit' or 'stand'.");
            }
        }

        // Dealer's turn
        while (dealer.getHandValue() < 17) {
            dealer.receiveCard(deck.drawCard());
        }
        dealer.displayHand();

        // Determine the winner
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        if (playerValue > 21) {
            System.out.println("Player busts. Dealer wins!");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts. Player wins!");
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins!");
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
