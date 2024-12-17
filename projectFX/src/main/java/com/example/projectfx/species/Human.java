package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;

public class Human extends Species {
    private int defensePower; // Human's ability to defend against attacks
    private static int nbhuman=0;

    public static int getNbhuman() {
        return nbhuman;
    }

    public static void setNbhuman(int nbhuman) {
        Human.nbhuman = nbhuman;
    }

    // Constructor
    public Human(String name, int energy, Positionn positionn, Environment environment, int defensePower,int vitesse) {
        super(name, energy, positionn, environment,vitesse);
        this.defensePower = defensePower;
        nbhuman++;
    }

    // Getter and setter for defensePower
    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    @Override
    public void eat(Object food) {

    }

    // Move the human in a specific direction
    @Override
    public void move(String direction) {
        System.out.println(name + " marche vers " + direction + ".");
        consumeEnergy(5); // Walking consumes energy
    }

    // Reproduce the human
    @Override
    public void reproduce() {
        System.out.println(name + " participe à l'extension de la communauté humaine.");
        if (canReproduce(nbhuman)) {
            nbhuman++; // Increment shark count during reproduction
            System.out.println(name + " (humans) has reproduced. Total sharks: " + nbhuman);
        } else {
            System.out.println(name + " (humans) cannot reproduce due to insufficient numbers.");
        }
    }



    // Human-specific defense mechanism
    public boolean defend(int attackPower) {
        System.out.println(name + " tente de se défendre contre une attaque.");
        if (defensePower >= attackPower) {
            System.out.println(name + " a réussi à se défendre avec succès !");
            return true; // Successful defense
        } else {
            System.out.println(name + " a échoué à se défendre.");
            return false; // Defense failed
        }
    }

    // Interaction with another species
    public void interactWith(Species otherSpecies) {
        System.out.println(name + " interagit avec " + otherSpecies.getName() + ".");
        if (otherSpecies instanceof Herbivore) {
            System.out.println(name + " nourrit " + otherSpecies.getName() + ".");
            otherSpecies.setEnergy(otherSpecies.getEnergy() + 10);
        } else if (otherSpecies instanceof Carnivore) {
            System.out.println(name + " garde ses distances avec " + otherSpecies.getName() + ".");
        } else {
            System.out.println(name + " observe " + otherSpecies.getName() + ".");
        }
    }

    @Override
    public void sleep() {
        if (!sleeping) {
            sleeping = true;
            energy += 10; // Rabbits regenerate a moderate amount of energy while sleeping
            System.out.println(name + " (Rabbit) is now sleeping. Energy: " + energy);
        } else {
            System.out.println(name + " (Rabbit) is already sleeping.");
        }
    }

    @Override
    public void wakeUp() {
        if (sleeping) {
            sleeping = false;
            System.out.println(name + " (Rabbit) has woken up.");
        } else {
            System.out.println(name + " (Rabbit) is already awake.");
        }
    }

    @Override
    public boolean isSleeping() {
        return sleeping;
    }
}