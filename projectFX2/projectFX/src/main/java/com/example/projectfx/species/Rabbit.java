package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;
import com.example.projectfx.resources.Fruits;
import com.example.projectfx.resources.Grass;

public class Rabbit extends Herbivore {
    private double speed; // Speed of the rabbit in m/s
    private static int nbrabbit=0;
    // Constructor
    public Rabbit(String name, int energy, Positionn positionn, Environment environment, double speed,int vitesse) {
        super(name, energy, positionn, environment, true,vitesse); // Rabbits typically have grouping instinct
        this.speed = speed;
        nbrabbit++;
    }

    // Getters and setters for speed
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Move the rabbit in a specified direction
    @Override
    public void move(String direction) {
        System.out.println(name + " saute rapidement vers " + direction + " à une vitesse de " + speed + " m/s.");
        consumeEnergy(5); // Moving consumes energy
    }

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

    // Reproduce the rabbit
    @Override
    public void reproduce() {
        System.out.println(name + " se reproduit rapidement et donne naissance à de nouveaux lapereaux.");
        if (canReproduce(nbrabbit)) {
            nbrabbit++; // Increment shark count during reproduction
            System.out.println(name + " (rabbits) has reproduced. Total sharks: " + nbrabbit);
        } else {
            System.out.println(name + " (rabbits) cannot reproduce due to insufficient numbers.");
        }
    }

    public static int getNbrabbit() {
        return nbrabbit;
    }

    public static void setNbrabbit(int nbrabbit) {
        Rabbit.nbrabbit = nbrabbit;
    }


    // Detect predator and flee
    @Override
    public void detecterPredateur() {
        System.out.println(name + " cherche des prédateurs.");
        if (Math.random() < 0.7) { // 70% chance to detect a predator
            System.out.println(name + " détecte un prédateur et s'enfuit !");
            flee();
        } else {
            System.out.println(name + " ne détecte aucun prédateur pour l'instant.");
        }
    }

    @Override
    public void sleep() {
        if (!isSleeping()) {
            sleeping = true;
            energy += 10; // Sleeping restores energy
            System.out.println(name + " (rabbit) is now sleeping. Energy: " + energy);
        } else {
            System.out.println(name + " (rabbit) is already sleeping.");
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
        return false;
    }
}