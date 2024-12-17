package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;
import com.example.projectfx.interfaces.Consumable;
import com.example.projectfx.interfaces.Movable;
import com.example.projectfx.interfaces.Reproducible;
import com.example.projectfx.interfaces.Sleepable;

public abstract class Species implements Movable, Reproducible, Sleepable{
    protected String name;          // Name of the species
    protected int energy;           // Current energy level
    protected Positionn positionn;    // Current position in the environment
    protected Environment environment; // Environment the species belongs to
    protected int vitesse;
    protected boolean sleeping;

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    // Constructor
    public Species(String name, int energy, Positionn positionn, Environment environment, int vitesse) {
        this.name = name;
        this.energy = energy;
        this.positionn = positionn;
        this.environment = environment;
        this.vitesse = vitesse;
        this.sleeping = false; // Default state is awake
    }
    public abstract void eat(Object food);

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(0, energy); // Ensure energy is not negative
    }

    public Positionn getPosition() {
        return positionn;
    }

    public void setPosition(Positionn positionn) {
        this.positionn = positionn;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void move(String direction); // Movement logic
    public abstract void reproduce();// Reproduction logic

    @Override
    public boolean canReproduce(int a) {
        if(a>=2)
        {
            return true;
        }
        else {
            return false;
        }
    }
    public void checkDeath() {
        if (energy <= 0) {
            System.out.println(name + " has died due to lack of energy.");
            environment.retirerEspece(this); // Use retirerEspece to remove from species list
        }
    }

    public void reduceEnergy(int amount) {
        energy -= amount;
        System.out.println(name + "'s energy reduced by " + amount + ". Current energy: " + energy);
        checkDeath();
    }


    // Consume energy for actions
    public void consumeEnergy(int amount) {
        this.energy = Math.max(0, this.energy - amount); // Reduce energy, ensure non-negative
        System.out.println(name + " a consommé " + amount + " unités d'énergie. Énergie restante : " + energy);
    }


    // Check if the species is alive
    public boolean isAlive() {
        return energy > 0;
    }

    // String representation for debugging
    @Override
    public String toString() {
        return name + " (Énergie : " + energy + ", Position : " + positionn + ")";
    }
    public void sleep() {
        if (!sleeping) {
            sleeping = true;
            energy += 20; // Regenerate energy during sleep
            System.out.println(name + " is now sleeping. Energy: " + energy);
        } else {
            System.out.println(name + " is already sleeping.");
        }
    }
    public void handlePredatorAttack(Species predator) {
        if (sleeping) {
            System.out.println(name + " is sleeping and is attacked by " + predator.getName() + "!");
            // Decide whether the prey can escape or is eaten
            if (energy > predator.getEnergy()) {
                wakeUp();
                move("away");
                System.out.println(name + " woke up and escaped from " + predator.getName() + "!");
            } else {
                System.out.println(name + " couldn't escape and was eaten by " + predator.getName() + "...");
                // Logic to remove this species from the environment
                environment.retirerEspece(this);
            }
        } else {
            System.out.println(name + " is awake and can defend itself!");
            // Additional logic for defending or fighting back can be added here
        }
    }

    @Override
    public void wakeUp() {
        if (sleeping) {
            sleeping = false;
            System.out.println(name + " has woken up.");
        } else {
            System.out.println(name + " is already awake.");
        }
    }

    @Override
    public boolean isSleeping() {
        return sleeping;
    }
}
