package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;

public class Wolf extends Carnivore {
    private boolean packInstinct; // Whether the wolf hunts in a pack
    private static int nbwolf=0;

    // Constructor
    public Wolf(String name, int energy, Positionn positionn, Environment environment, boolean packInstinct,int vitesse) {
        super(name, energy, positionn, environment, 30, vitesse); // Default attack strength: 30
        this.packInstinct = packInstinct;
        nbwolf++;
    }

    // Getter and setter for packInstinct
    public boolean hasPackInstinct() {
        return packInstinct;
    }

    public void setPackInstinct(boolean packInstinct) {
        this.packInstinct = packInstinct;
    }

    @Override
    public void eat(Object food) {

    }

    // Move the wolf in a specific direction
    @Override
    public void move(String direction) {
        System.out.println(name + " se déplace en meute vers " + direction + ".");
        consumeEnergy(8); // Moving consumes 8 energy units
    }

    public static int getNbwolf() {
        return nbwolf;
    }

    public static void setNbwolf(int nbwolf) {
        Wolf.nbwolf = nbwolf;
    }

    // Wolf reproduction
    @Override
    public void reproduce() {
        System.out.println(name + " se reproduit en meute, augmentant la taille du groupe.");
        if (canReproduce(nbwolf)) {
            nbwolf++; // Increment shark count during reproduction
            System.out.println(name + " (wolfs) has reproduced. Total sharks: " + nbwolf);
        } else {
            System.out.println(name + " (wolfs) cannot reproduce due to insufficient numbers.");
        }
    }

    // Wolf-specific hunting behavior
    @Override
    public void hunt(Species prey) {
        if (packInstinct) {
            System.out.println(name + " chasse " + prey.getName() + " avec l'aide de sa meute.");
        } else {
            System.out.println(name + " chasse " + prey.getName() + " en solitaire.");
        }
        super.hunt(prey); // Call the general hunting logic from Carnivore
    }

    @Override
    public void sleep() {
        if (!sleeping) {
            sleeping = true;
            energy += 20; // Wolves regenerate energy efficiently while sleeping
            System.out.println(name + " (Wolf) is now sleeping. Energy: " + energy);
        } else {
            System.out.println(name + " (Wolf) is already sleeping.");
        }
    }

    @Override
    public void wakeUp() {
        if (sleeping) {
            sleeping = false;
            System.out.println(name + " (Wolf) has woken up.");
        } else {
            System.out.println(name + " (Wolf) is already awake.");
        }
    }

    @Override
    public boolean isSleeping() {
        return sleeping;
    }
}