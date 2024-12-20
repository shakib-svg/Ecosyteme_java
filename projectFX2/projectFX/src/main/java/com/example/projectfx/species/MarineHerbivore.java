package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;

public abstract class MarineHerbivore extends Herbivore {
    // Constructor
    public MarineHerbivore(String name, int energy, Positionn positionn, Environment environment, int vitesse) {
        super(name, energy, positionn, environment, false, vitesse); // Marine herbivores generally don't have grouping instincts
    }

    // Swim method for marine herbivores
    public void swim(String direction) {
        System.out.println(name + " nage vers " + direction + ".");
        consumeEnergy(5); // Swimming consumes energy
    }

    // Abstract methods to be implemented by subclasses
    @Override
    public abstract void move(String direction);

    @Override
    public abstract void reproduce();
}