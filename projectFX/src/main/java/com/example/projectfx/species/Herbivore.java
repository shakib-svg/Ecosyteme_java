package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;

public abstract class Herbivore extends Species {
    private boolean groupingInstinct; // Whether the herbivore prefers to stay in groups

    // Constructor
    public Herbivore(String name, int energy, Positionn positionn, Environment environment, boolean groupingInstinct,int vitesse) {
        super(name, energy, positionn, environment,vitesse);
        this.groupingInstinct = groupingInstinct;
    }

    // Getters and setters
    public boolean hasGroupingInstinct() {
        return groupingInstinct;
    }

    public void setGroupingInstinct(boolean groupingInstinct) {
        this.groupingInstinct = groupingInstinct;
    }

    // Detect predators
    public void detecterPredateur() {
        System.out.println(name + " cherche des prédateurs.");
        // Simple detection logic: could be enhanced based on proximity or environment
        if (Math.random() < 0.5) {
            System.out.println(name + " détecte un prédateur et tente de fuir !");
            flee();
        } else {
            System.out.println(name + " ne détecte aucun prédateur.");
        }
    }

    // Flee logic
    public void flee() {
        System.out.println(name + " fuit rapidement pour échapper au danger.");
        consumeEnergy(15); // Fleeing costs energy
    }

    // Abstract methods to be implemented by concrete herbivores
    @Override
    public abstract void move(String direction);

    @Override
    public abstract void reproduce();
}