package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;
import com.example.projectfx.interfaces.Consumable;
import com.example.projectfx.resources.Fruits;

public class Canari extends Herbivore {
    //private String featherColor; // Feather color of the canary
    private static int nbCanaries = 0; // Static variable to track the number of canaries
    private String featherColor;

    // Constructor
    public Canari(String name, int energy, Positionn positionn, Environment environment, int vitesse, String featherColor) {
        super(name, energy, positionn, environment, true, vitesse); // Canaries typically have a grouping instinct
        this.featherColor = featherColor;
        nbCanaries++;
    }

    // Getter and Setter for featherColor
    public String getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }

    // Getter and Setter for static variable nbCanaries
    public static int getNbCanaries() {
        return nbCanaries;
    }

    public static void setNbCanaries(int nbCanaries) {
        Canari.nbCanaries = nbCanaries;
    }

    // Movement logic
    @Override
    public void move(String direction) {
        if (isSleeping()) {
            System.out.println(name + " is sleeping and cannot move.");
        } else {
            System.out.println(name + " (Canari) flutters quickly towards " + direction + " at speed " + vitesse + " m/s.");
            reduceEnergy(5); // Flying consumes energy
        }
    }

    // Eating logic
    @Override
    public void eat(Object food) {
        if (food instanceof Fruits) {
            Fruits fruits = (Fruits) food;
            System.out.println(name + " consomme des fruits.");
            fruits.consume(20);
            energy += 20;
        } else {
            System.out.println(name + " ne peut pas manger cet aliment.");
        }
    }

    // Reproduction logic
    @Override
    public void reproduce() {
        System.out.println(name + " (Canari) is reproducing.");
        if (canReproduce(nbCanaries)) {
            nbCanaries++;
            System.out.println(name + " has successfully reproduced. Total canaries: " + nbCanaries);
        } else {
            System.out.println(name + " cannot reproduce due to insufficient numbers.");
        }
    }

    // Predator detection logic
    @Override
    public void detecterPredateur() {
        System.out.println(name + " (Canari) is scanning the area for predators.");
        if (Math.random() < 0.6) { // 60% chance to detect a predator
            System.out.println(name + " (Canari) detects a predator and flies away!");
            flee();
        } else {
            System.out.println(name + " (Canari) does not detect any predators for now.");
        }
    }

    // Fleeing logic
    @Override
    public void flee() {
        System.out.println(name + " (Canari) flutters away to escape danger!");
        reduceEnergy(10); // Fleeing consumes significant energy
    }

    // Sleeping logic
    @Override
    public void sleep() {
        if (!isSleeping()) {
            sleeping = true;
            energy += 15; // Sleeping restores energy
            System.out.println(name + " (Canari) is now sleeping. Energy: " + energy);
        } else {
            System.out.println(name + " (Canari) is already sleeping.");
        }
    }

    @Override
    public void wakeUp() {
        if (isSleeping()) {
            sleeping = false;
            System.out.println(name + " (Canari) has woken up.");
        } else {
            System.out.println(name + " (Canari) is already awake.");
        }
    }

   // @Override
//    public boolean isSleeping() {
//        return sleeping;
//    }
}
