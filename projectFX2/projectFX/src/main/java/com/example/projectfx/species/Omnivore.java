package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;
import com.example.projectfx.ecosystem.Positionn;
import com.example.projectfx.interfaces.Consumable;

public abstract class Omnivore extends Species {
    // Constructor
    public Omnivore(String name, int energy, Positionn position, Environment environment,int vitesse) {
        super(name, energy, position, environment,vitesse);
    }

    /**
     * Omnivore-specific eating behavior.
     *
     * @param food The food to be consumed (could be a Resource or another Species).
     */
    public void eat(Object food) {
        if (food instanceof Species) {
            Species prey = (Species) food;
            System.out.println(name + " attaque et mange " + prey.getName() + ".");
            if (prey.getEnergy() <= 20) { // Example: Omnivore consumes prey if energy <= 20
                System.out.println(prey.getName() + " est complètement mangé par " + name + ".");
                energy += prey.getEnergy();
                prey.setEnergy(0);
                prey.checkDeath();
            } else {
                System.out.println(prey.getName() + " perd de l'énergie après l'attaque.");
                prey.setEnergy(prey.getEnergy() - 20);
                energy += 20;
            }
        } else if (food instanceof Consumable) {
            Consumable resource = (Consumable) food;
            System.out.println(name + " consomme des ressources.");
            resource.consume(10); // Example: Omnivore consumes 10 units
            energy += 10;
        } else {
            System.out.println(name + " ne peut pas manger cet aliment.");
        }
    }

    // Abstract methods to be implemented by subclasses
    @Override
    public abstract void move(String direction);

    @Override
    public abstract void reproduce();
}