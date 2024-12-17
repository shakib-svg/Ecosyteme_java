package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;

public class Shark extends Carnivore {
    private int attackStrength; // Strength of the shark's attack
    private double swimSpeed;   // Speed of the shark in m/s
    private static int nbshark=0;

    // Constructor
    public Shark(String name, int energy, Positionn positionn, Environment environment, int attackStrength, double swimSpeed,int vitesse) {
        super(name, energy, positionn, environment, attackStrength,vitesse);
        this.attackStrength = attackStrength;
        this.swimSpeed = swimSpeed;
        nbshark++;
    }

    // Getters and setters
    public double getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(double swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    @Override
    public void eat(Object food) {

    }

    // Move the shark
    @Override
    public void move(String direction) {
        System.out.println(name + " nage rapidement vers " + direction + " à une vitesse de " + swimSpeed + " m/s.");
        consumeEnergy(10); // Swimming consumes energy
    }

    public static int getNbshark() {
        return nbshark;
    }

    public static void setNbshark(int nbshark) {
        Shark.nbshark = nbshark;
    }

    // Reproduce the shark
    @Override
    public void reproduce() {
        System.out.println(name + " se reproduit en pondant des œufs.");
        if (canReproduce(nbshark)) {
            nbshark++; // Increment shark count during reproduction
            System.out.println(name + " (sharks) has reproduced. Total sharks: " + nbshark);
        } else {
            System.out.println(name + " (sharks) cannot reproduce due to insufficient numbers.");
        }
    }

    // Hunt behavior for sharks
    @Override
    public void hunt(Species prey) {
        System.out.println(name + " chasse " + prey.getName() + " dans l'océan.");
        if (this.environment.equals(prey.getEnvironment()) &&
                this.positionn.calculateDistance(prey.getPosition()) <= 5) { // Sharks have a larger hunting range
            attack(prey);
        } else {
            System.out.println(prey.getName() + " est hors de portée.");
        }
    }

    // Shark-specific attack behavior
    @Override
    public void attack(Species prey) {
        System.out.println(name + " attaque violemment " + prey.getName() + " avec une force de " + attackStrength + ".");
        if (prey.getEnergy() <= attackStrength) {
            eat(prey);
        } else {
            System.out.println(prey.getName() + " survit à l'attaque mais perd de l'énergie.");
            prey.setEnergy(prey.getEnergy() - attackStrength);
        }
    }

    @Override
    public void sleep() {
        if (!sleeping) {
            sleeping = true;
            energy += 10; // Sharks regenerate energy moderately while sleeping
            System.out.println(name + " (Shark) is now sleeping while floating. Energy: " + energy);
        } else {
            System.out.println(name + " (Shark) is already sleeping.");
        }
    }

    @Override
    public void wakeUp() {
        if (sleeping) {
            sleeping = false;
            System.out.println(name + " (Shark) has woken up and is now actively swimming.");
        } else {
            System.out.println(name + " (Shark) is already awake.");
        }
    }

    @Override
    public boolean isSleeping() {
        return sleeping;
    }
}