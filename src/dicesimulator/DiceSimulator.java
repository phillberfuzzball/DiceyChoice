/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dicesimulator;

/**
 *
 * @author Phill
 */
        import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dicesimulator.Players;
import dicesimulator.DiceSets;

public class DiceSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Dice Simulator!");

        // Prompt for the number of players
        System.out.print("How many players? ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        // Create a list to store player objects
        List<Players> players = new ArrayList<>();

        // Get player names
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String playerName = scanner.nextLine();
            players.add(new Players(playerName));
        }

        // Create a DiceSet
        DiceSets diceSet = new DiceSets();

        // Prompt players to choose a dice set
        System.out.print("Choose a dice set (S for Standard, C for Custom): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("C")) {
            diceSet.createCustomDiceSet();
        }

        // Game is starting
        System.out.println("Let's start the game!");

        // Roll dice for each player
        for (Players player : players) {
            System.out.print(player.getName() + ", how many dice do you want to roll? ");
            int numDiceToRoll = scanner.nextInt();
            scanner.nextLine();

            System.out.print(player.getName() + ", enter the number of faces for each dice (e.g., 6, 8, 20): ");
            String diceFacesInput = scanner.nextLine();
            String[] diceFaces = diceFacesInput.split(", ");

            System.out.println(player.getName() + " is rolling:");

            for (String diceFace : diceFaces) {
                // Calculate the number of sides for the custom dice
                int numSides = Integer.parseInt(diceFace);
                
                // Roll the dice and display the result
                player.rollDice(diceSet, "D" + numSides);
                System.out.println("Rolling D" + numSides + " - Result: " + player.getLastRoll());
            }

            // Pause for player to continue
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
        }

        // Game results (you can add more logic here)
        for (Players player : players) {
            System.out.println(player.getName() + "'s Roll History: " + player.getRollHistory());
        }

        scanner.close();
    }
}