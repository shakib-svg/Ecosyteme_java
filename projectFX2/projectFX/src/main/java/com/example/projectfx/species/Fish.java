package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;
import com.example.projectfx.interfaces.Consumable;
import com.example.projectfx.resources.Algae;

public class Fish extends MarineHerbivore {
    private double swimSpeed; // Speed of the fish in m/s
    private static int nbfish=0;

    // Constructor
    public Fish(String name, int energy, Positionn positionn, Environment environment, double swimSpeed, int vitesse) {
        super(name, energy, positionn, environment,vitesse);
        this.swimSpeed = swimSpeed;
        nbfish++;
    }

    public static int getNbfish() {
        return nbfish;
    }

    public static void setNbfish(int nbfish) {
        Fish.nbfish = nbfish;
    }

    // Getter and setter for swimSpeed
    public double getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(double swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void eat(Object food) {
        if (food instanceof Algae) {
            Algae algae = (Algae) food;
            System.out.println(name + " consomme des fruits.");
            algae.consume(20);
            energy += 20;
        } else {
            System.out.println(name + " ne peut pas manger cet aliment.");
        }
    }

    // Move the fish
    @Override
    public void move(String direction) {
        System.out.println(name + " nage rapidement vers " + direction + " à une vitesse de " + swimSpeed + " m/s.");
        consumeEnergy(5); // Swimming consumes energy
    }

    // Reproduce the fish
    @Override
    public void reproduce() {
        System.out.println(name + " pond des œufs dans l'océan.");
        if (canReproduce(nbfish)) {
            nbfish++; // Increment shark count during reproduction
            System.out.println(name + " (fishes) has reproduced. Total sharks: " + nbfish);
        } else {
            System.out.println(name + " (fishes) cannot reproduce due to insufficient numbers.");
        }

    }


    // Detect predators in the ocean
    @Override
    public void detecterPredateur() {
        System.out.println(name + " cherche des prédateurs dans l'eau.");
        if (Math.random() < 0.6) { // 60% chance to detect a predator
            System.out.println(name + " détecte un prédateur et tente de fuir !");
            swim("loin du danger");
        } else {
            System.out.println(name + " ne détecte aucun prédateur pour l'instant.");
        }
    }

    @Override
    public void sleep() {
        if (!sleeping) {
            sleeping = true;
            energy += 5; // Fish regenerate less energy while sleeping
            System.out.println(name + " (Fish) is now sleeping. Energy: " + energy);
        } else {
            System.out.println(name + " (Fish) is already sleeping.");
        }
    }

    @Override
    public void wakeUp() {
        if (sleeping) {
            sleeping = false;
            System.out.println(name + " (Fish) has woken up.");
        } else {
            System.out.println(name + " (Fish) is already awake.");
        }
    }

    @Override
    public boolean isSleeping() {
        return sleeping;
    }
}