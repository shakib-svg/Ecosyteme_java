package com.example.projectfx.species;

import com.example.projectfx.ecosystem.Environment;
import com.example.projectfx.ecosystem.Positionn;

public class HerbivorousFish extends MarineHerbivore {
    private double swimSpeed;

    public HerbivorousFish(String name, int energy, Positionn positionn, Environment environment, double swimSpeed,int vitesse) {
        super(name, energy, positionn,environment,vitesse);
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void detecterPredateur() {
        System.out.println(name + " détecte un prédateur et nage rapidement à une vitesse de " + swimSpeed + " m/s.");
    }

    @Override
    public void eat(Object food) {

    }

    @Override
    public void move(String direction) {
        nager(direction); // Appelle la méthode spécifique à la nage
    }

    private void nager(String direction) {
    }

    @Override
    public void reproduce() {
        System.out.println(name + " pond des œufs pour se reproduire.");
    }


    @Override
    public void sleep() {

    }

    @Override
    public void wakeUp() {

    }

    @Override
    public boolean isSleeping() {
        return false;
    }
}
