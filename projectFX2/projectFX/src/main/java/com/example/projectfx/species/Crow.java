package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;
import com.example.projectfx.interfaces.Consumable;
import com.example.projectfx.resources.Fruits;

public class Crow extends Omnivore {
    private static int nbCrows = 0; // Static variable to track the number of crows
    private String featherColor;

    // Constructor
    public Crow(String name, int energy, Positionn positionn, Environment environment, int vitesse, String featherColor) {
        super(name, energy, positionn, environment, vitesse);
        this.featherColor = featherColor;
        nbCrows++;
    }

    // Getter and Setter for featherColor
    public String getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }

    // Getter and Setter for static variable nbCrows
    public static int getNbCrows() {
        return nbCrows;
    }

    public static void setNbCrows(int nbCrows) {
        Crow.nbCrows = nbCrows;
    }

    // Movement logic
    @Override
    public void move(String direction) {
        if (isSleeping()) {
            System.out.println(name + " is sleeping and cannot move.");
        } else {
            System.out.println(name + " (Crow) flies swiftly towards " + direction + " at speed " + vitesse + " m/s.");
            reduceEnergy(5); // Flying consumes energy
        }
    }

    // Eating logic
    @Override
    public void eat(Object food) {
        if (food instanceof Fruits) {
            Fruits fruits = (Fruits) food;
            System.out.println(name + " consomme des fruits.");
            fruits.consume(15);
            energy += 15;
        } else if (food instanceof Species) {
            Species prey = (Species) food;
            System.out.println(name + " attaque et mange " + prey.getName() + ".");
            if (prey.getEnergy() <= 30) {
                System.out.println(prey.getName() + " est complètement mangé par " + name + ".");
                energy += prey.getEnergy();
                prey.setEnergy(0);
            } else {
                System.out.println(prey.getName() + " perd de l'énergie après l'attaque.");
                prey.setEnergy(prey.getEnergy() - 30);
                energy += 30;
            }
        } else {
            System.out.println(name + " ne peut pas manger cet aliment.");
        }
    }

    // Reproduction logic
    @Override
    public void reproduce() {
        System.out.println(name + " (Crow) is reproducing.");
        if (canReproduce(nbCrows)) {
            nbCrows++;
            System.out.println(name + " has successfully reproduced. Total crows: " + nbCrows);
        } else {
            System.out.println(name + " cannot reproduce due to insufficient numbers.");
        }
    }

    // Sleeping logic
    @Override
    public void sleep() {
        if (!isSleeping()) {
            sleeping = true;
            energy += 20; // Sleeping restores energy
            System.out.println(name + " (Crow) is now sleeping. Energy: " + energy);
        } else {
            System.out.println(name + " (Crow) is already sleeping.");
        }
    }

    @Override
    public void wakeUp() {
        if (isSleeping()) {
            sleeping = false;
            System.out.println(name + " (Crow) has woken up.");
        } else {
            System.out.println(name + " (Crow) is already awake.");
        }
    }
}
