/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BlackjackTest {
    public static void main(String[] args) {
        testGoodCases();
        testBadCases();
        testBoundaryCases();
    }

    public static void testGoodCases() {
        System.out.println("Testing Good Cases:");

        // Test case: Player wins
        simulateGame("2", "3", "5", "Ace", "7", "10"); // Player wins

        // Test case: Dealer wins
        simulateGame("9", "6", "8", "7", "King", "3"); // Dealer wins

        // Test case: Tie
        simulateGame("7", "8", "9", "King", "3", "2"); // Tie

        // Test case: Player gets a Blackjack
        simulateGame("Ace", "10", "8", "5", "4", "6"); // Player wins
           
    }

    public static void testBadCases() {
        System.out.println("Testing Bad Cases:");

        // Test case: Invalid input from player
        simulateGameWithInput("3", "7", "Jack", "King", "6", "10", "stand", "wrong"); // Invalid input

        // Test case: Empty deck
        simulateEmptyDeck();
       
    }

    public static void testBoundaryCases() {
         System.out.println("Testing Boundary Cases:");

        // Test case: Player gets 21
        simulateGame("9", "2", "Ace", "10"); // Player wins

        // Test case: Dealer must hit multiple times to reach 17
        simulateGame("9", "5", "3", "King", "4", "6"); // Dealer wins
    
    }

 // Simulate a game with given initial cards
    private static void simulateGame(String... cardValues) {
        System.out.println("Simulating game with cards: " + Arrays.toString(cardValues));
        Blackjack blackjack = new Blackjack();
        // Mock user inputs for player decisions

        String[] decisions = { "hit", "hit", "stand" };

        // Mock the shuffled deck
        List<Card> mockDeck = createMockDeck(cardValues);
        blackjack.setMockDeck(mockDeck);

        // Redirect input to simulate user choices
        for (String decision : decisions) {
            ByteArrayInputStream input = new ByteArrayInputStream(decision.getBytes());
            System.setIn(input);
            Blackjack.main(new String[0]);
        }
        System.out.println();
    }

    // Simulate a game with given initial cards and user inputs
    private static void simulateGameWithInput(String... inputs) {
        System.out.println("Simulating game with inputs: " + Arrays.toString(inputs));
        Blackjack blackjack = new Blackjack();
        
        // Mock the shuffled deck
        List<Card> mockDeck = createMockDeck(inputs);
        blackjack.setMockDeck(mockDeck);

        // Redirect input to simulate user choices
        for (String input : inputs) {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);
            Blackjack.main(new String[0]);
        }
        System.out.println();
    }

    // Simulate a game with an empty deck
    private static void simulateEmptyDeck() {
        System.out.println("Simulating game with an empty deck:");
        Scanner scanner = new Scanner(System.in);
        Blackjack blackjack = new Blackjack();
        
        // Mock an empty deck
        List<Card> mockDeck = new ArrayList<>();
        blackjack.setMockDeck(mockDeck);

        // Simulate player's turn
        simulatePlayerTurn(scanner, blackjack);

        // Simulate dealer's turn
        simulateDealerTurn(blackjack);
    }

    // Create a mock deck based on provided card values
    private static List<Card> createMockDeck(String... cardValues) {
        List<Card> mockDeck = new ArrayList<>();
        for (String value : cardValues) {
            mockDeck.add(new Card("MockSuit", value));
        }
        return mockDeck;
    }

    // Simulate player's turn
    private static void simulatePlayerTurn(Scanner scanner, Blackjack blackjack) {
        for (int i = 0; i < 3; i++) {
            ByteArrayInputStream inputStream = new ByteArrayInputStream("hit".getBytes());
            System.setIn(inputStream);
            blackjack.main(new String[0]);
        }
    }

    // Simulate dealer's turn
    private static void simulateDealerTurn(Blackjack blackjack) {
        blackjack.main(new String[0]);
    }
}

    

