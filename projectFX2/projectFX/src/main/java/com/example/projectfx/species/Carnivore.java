package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;

public abstract class Carnivore extends Species {
    private int attackStrength; // Strength of the carnivore's attack

    // Constructor
    public Carnivore(String name, int energy, Positionn positionn, Environment environment, int attackStrength, int vitesse) {
        super(name, energy, positionn, environment, vitesse);
        this.attackStrength = attackStrength;
    }

    // Getters and setters
    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    // Hunt behavior
    public void hunt(Species prey) {
        System.out.println(name + " chasse " + prey.getName() + ".");

        // Check if prey is in the same environment and close enough
        if (this.environment.equals(prey.getEnvironment()) &&
                this.positionn.calculateDistance(prey.getPosition()) <= 3) {
            attack(prey);
        } else {
            System.out.println(prey.getName() + " est trop loin ou dans un autre environnement.");
        }
    }

    // Attack prey
    public void attack(Species prey) {
        System.out.println(name + " attaque " + prey.getName() + " avec une force de " + attackStrength + ".");

        if (prey.getEnergy() <= attackStrength) {
            eat(prey);
        } else {
            System.out.println(prey.getName() + " survit à l'attaque mais perd de l'énergie.");
            prey.setEnergy(prey.getEnergy() - attackStrength);
        }
    }

    // Eat prey
    public void eat(Species prey) {
        System.out.println(name + " mange " + prey.getName() + ".");
        this.energy += prey.getEnergy(); // Gain prey's energy
        prey.setEnergy(0); // Prey is consumed (dies)
        prey.checkDeath();

    }

    // Abstract methods to be implemented by subclasses
    @Override
    public abstract void move(String direction);

    @Override
    public abstract void reproduce();
}