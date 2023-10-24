/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicesimulator;

/**
 *
 * @author Phill
 */
import java.util.Scanner;

public class DiceSets {
    private String[] dndDiceTypes = { "D4", "D6", "D8", "D10", "D10", "D12", "D20" };
    private int[] dndNumSides = { 4, 6, 8, 10, 10, 12, 20 };

    private String[] customDiceTypes;
    private int[] customNumSides;

    public DiceSets() {
        // Initialize D&D dice set
        // No custom dice set initially
    }

    public int getNumSides(String diceType) {
        for (int i = 0; i < dndDiceTypes.length; i++) {
            if (dndDiceTypes[i].equalsIgnoreCase(diceType)) {
                return dndNumSides[i];
            }
        }
        if (customDiceTypes != null) {
            for (int i = 0; i < customDiceTypes.length; i++) {
                if (customDiceTypes[i].equalsIgnoreCase(diceType)) {
                    return customNumSides[i];
                }
            }
        }
        return -1; // Not found
    }

    public String[] getDiceTypes() {
        if (customDiceTypes != null) {
            String[] allDiceTypes = new String[dndDiceTypes.length + customDiceTypes.length];
            System.arraycopy(dndDiceTypes, 0, allDiceTypes, 0, dndDiceTypes.length);
            System.arraycopy(customDiceTypes, 0, allDiceTypes, dndDiceTypes.length, customDiceTypes.length);
            return allDiceTypes;
        }
        return dndDiceTypes;
    }

    public void createCustomDiceSet() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many custom dice do you want to create? ");
        int numCustomDice = scanner.nextInt();
        scanner.nextLine();

        customDiceTypes = new String[numCustomDice];
        customNumSides = new int[numCustomDice];

        for (int i = 0; i < numCustomDice; i++) {
            System.out.print("Enter the name for custom dice " + (i + 1) + ": ");
            customDiceTypes[i] = scanner.nextLine();
            System.out.print("Enter the number of sides for " + customDiceTypes[i] + ": ");
            customNumSides[i] = scanner.nextInt();
            scanner.nextLine();
        }
    }

    // Other methods for rolling dice, etc.
}
