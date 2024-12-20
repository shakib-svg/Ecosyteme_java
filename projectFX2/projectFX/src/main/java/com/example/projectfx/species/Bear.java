package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;
import com.example.projectfx.interfaces.Consumable;

public class Bear extends Omnivore {
    private double strength; // Strength of the bear for attacking
    private double speed;// Speed of the bear in m/s
    private static int nbbears=0;

    // Constructor
    public Bear(String name, int energy, Positionn position, Environment environment, double strength, double speed,int vitesse) {
        super(name, energy, position, environment,vitesse);
        this.strength = strength;
        this.speed = speed;
    }

    // Getters and setters
    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Bear movement
    @Override
    public void move(String direction) {
        System.out.println(name + " se déplace lentement mais avec force vers " + direction + " à une vitesse de " + speed + " m/s.");
        consumeEnergy(10); // Movement consumes energy
    }

    // Bear reproduction
    @Override
    public void reproduce() {
        System.out.println(name + " participe à l'extension de la communauté bears.");
        if (canReproduce(nbbears)) {
            nbbears++; // Increment shark count during reproduction
            System.out.println(name + " (bears) has reproduced. Total humans: " + nbbears);
        } else {
            System.out.println(name + " (bears) cannot reproduce due to insufficient numbers.");
        }
    }

    // Bear-specific eating behavior
    @Override
    public void eat(Object food) {
        if (food instanceof Species) {
            Species prey = (Species) food;
            System.out.println(name + " attaque et mange " + prey.getName() + ".");
            if (prey.getEnergy() <= strength) {
                System.out.println(prey.getName() + " est complètement mangé par " + name + ".");
                energy += prey.getEnergy();
                prey.setEnergy(0);
            } else {
                System.out.println(prey.getName() + " perd de l'énergie après l'attaque.");
                prey.setEnergy(prey.getEnergy() - (int) strength);
                energy += (int) strength;
            }
        } else if (food instanceof Consumable) {
            Consumable resource = (Consumable) food;
            System.out.println(name + " consomme une ressource.");
            resource.consume(20); // Bear consumes 20 units of a resource
            energy += 20;
        } else {
            System.out.println(name + " ne peut pas manger cet aliment.");
        }
    }

    @Override
    public void sleep() {
        if (!sleeping) {
            sleeping = true;
            energy += 30; // Bears regenerate the most energy while hibernating
            System.out.println(name + " (Bear) is now sleeping (hibernating). Energy: " + energy);
        } else {
            System.out.println(name + " (Bear) is already sleeping.");
        }
    }

    @Override
    public void wakeUp() {
        if (sleeping) {
            sleeping = false;
            System.out.println(name + " (Bear) has woken up from hibernation.");
        } else {
            System.out.println(name + " (Bear) is already awake.");
        }
    }

    @Override
    public boolean isSleeping() {
        return sleeping;
    }
}