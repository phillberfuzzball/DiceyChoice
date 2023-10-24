/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicesimulator;

/**
 *
 * @author Phill
 */
import java.util.ArrayList;
import java.util.List;

public class Players {
    private String name;
    private int lastRoll;
    private List<Integer> rollHistory;

    public Players(String name) {
        this.name = name;
        this.rollHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getLastRoll() {
        return lastRoll;
    }

    public List<Integer> getRollHistory() {
        return rollHistory;
    }

    public void rollDice(DiceSets diceSet, String diceType) {
        int numSides = diceSet.getNumSides(diceType);
        if (numSides > 0) {
            // Simulate rolling the dice and update the player's last roll
            lastRoll = (int) (Math.random() * numSides) + 1;
            // Add the last roll to the roll history
            rollHistory.add(lastRoll);
        }
    }
}
