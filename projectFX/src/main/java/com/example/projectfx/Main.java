package com.example.projectfx;

import com.example.projectfx.species.*;
import com.example.projectfx.resources.*;
import com.example.projectfx.ecosystem.*;

public class Main {
    public static void main(String[] args) {
        // Create environments
        Forest forest = new Forest(0.1);
        Ocean ocean = new Ocean(0.5);

        // Create positions for species
        Positionn bearPosition1 = new Positionn(2, 3);
        Positionn bearPosition2 = new Positionn(5, 6);
        Positionn wolfPosition1 = new Positionn(3, 4);
        Positionn wolfPosition2 = new Positionn(7, 8);
        Positionn humanPosition1 = new Positionn(1, 2);
        Positionn humanPosition2 = new Positionn(6, 7);
        Positionn sharkPosition1 = new Positionn(4, 4);
        Positionn sharkPosition2 = new Positionn(6, 5);
        Positionn fishPosition1 = new Positionn(3, 3);
        Positionn fishPosition2 = new Positionn(7, 6);

        // Create species with "vitesse"
        Bear bear1 = new Bear("Bear1", 80, bearPosition1, forest, 50, 2.0, 10); // vitesse = 10
        Bear bear2 = new Bear("Bear2", 70, bearPosition2, forest, 60, 1.8, 12); // vitesse = 12
        Wolf wolf1 = new Wolf("Wolf1", 50, wolfPosition1, forest, true, 15);    // vitesse = 15
        Wolf wolf2 = new Wolf("Wolf2", 55, wolfPosition2, forest, false, 18);   // vitesse = 18
        Human human1 = new Human("Human1", 90, humanPosition1, forest, 30, 8); // vitesse = 8
        Human human2 = new Human("Human2", 85, humanPosition2, forest, 25, 9); // vitesse = 9
        Shark shark1 = new Shark("Shark1", 60, sharkPosition1, ocean, 70, 3.0, 20); // vitesse = 20
        Shark shark2 = new Shark("Shark2", 65, sharkPosition2, ocean, 75, 2.8, 22); // vitesse = 22
        Fish fish1 = new Fish("Fish1", 40, fishPosition1, ocean, 1.5, 5);       // vitesse = 5
        Fish fish2 = new Fish("Fish2", 35, fishPosition2, ocean, 1.2, 6);       // vitesse = 6

        // Create resources
        Grass grass = new Grass(100, 0.2);
        Algae algae = new Algae(80, 0.3);

        // Add species and resources to environments
        forest.ajouterEspece(bear1);
        forest.ajouterEspece(bear2);
        forest.ajouterEspece(wolf1);
        forest.ajouterEspece(wolf2);
        forest.ajouterEspece(human1);
        forest.ajouterEspece(human2);
        forest.ajouterResource(grass);

        ocean.ajouterEspece(shark1);
        ocean.ajouterEspece(shark2);
        ocean.ajouterEspece(fish1);
        ocean.ajouterEspece(fish2);
        ocean.ajouterResource(algae);

        // Display initial state
        System.out.println("=== État initial de l'écosystème ===");
        System.out.println("Forêt : " + forest);
        System.out.println("Océan : " + ocean);

        // Simulate seasonal changes and interactions
        System.out.println("\n=== Début de la simulation ===");

        // Spring (Reproduction season)
        System.out.println("\n--- Printemps ---");
        forest.mettreAJourSaison("Spring");
        ocean.mettreAJourSaison("Spring");
        bear1.reproduce();
        bear2.reproduce();
        fish1.reproduce();
        fish2.reproduce();

        // Summer (High activity, wolves and bears hunt)
        System.out.println("\n--- Été ---");
        forest.mettreAJourSaison("Summer");
        ocean.mettreAJourSaison("Summer");
        wolf1.hunt(bear1); // Wolf1 attacks Bear1
        bear2.eat(grass);  // Bear2 eats grass
        shark1.hunt(fish1); // Shark1 hunts Fish1

        // Autumn (Humans interact with species and gather resources)
        System.out.println("\n--- Automne ---");
        forest.mettreAJourSaison("Autumn");
        ocean.mettreAJourSaison("Autumn");
        human1.interactWith(bear1); // Human1 interacts with Bear1
       // human2.interactWith(grass); // Human2 gathers grass

        // Winter (Limited resources, survival mode)
        System.out.println("\n--- Hiver ---");
        forest.mettreAJourSaison("Winter");
        ocean.mettreAJourSaison("Winter");
        grass.regenerate(); // Grass grows slower in winter
        algae.regenerate(); // Algae reproduces
        wolf2.hunt(human1); // Wolf2 attacks Human1
        shark2.hunt(fish2); // Shark2 hunts Fish2

        // Display final state
        System.out.println("\n=== État final de l'écosystème ===");
        System.out.println("Forêt : " + forest);
        System.out.println("Océan : " + ocean);
    }
}
