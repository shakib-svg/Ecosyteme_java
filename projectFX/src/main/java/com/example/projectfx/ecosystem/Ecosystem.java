package com.example.projectfx.ecosystem;

import com.example.projectfx.species.Species;

import java.util.ArrayList;
import java.util.List;

public class Ecosystem {
    private List<Environment> listOfEnvironments = new ArrayList<>();
    private List<Species> listOfSpecies = new ArrayList<>();

    // Lancer la simulation
    public void lancerSimulation() {
        System.out.println("Simulation démarrée.");
        for (Environment environment : listOfEnvironments) {
            environment.appliquerReglesEnvironment();
        }
        mettreAJourCycle();
    }

    // Mettre à jour chaque cycle (espèces et environnement)
    public void mettreAJourCycle() {
        System.out.println("\n=== Mise à jour du cycle ===");
        for (Species species : listOfSpecies) {
            species.move("dans une direction aléatoire");
            species.reproduce();
        }
        for (Environment environment : listOfEnvironments) {
            environment.mettreAJourSaison("Spring");
        }
    }

    // Afficher l'état actuel de l'écosystème
    public void afficherEcosysteme() {
        System.out.println("\n=== État de l'écosystème ===");
        for (Environment environment : listOfEnvironments) {
            System.out.println("Environnement : " + environment.getClass().getSimpleName());
            System.out.println("Espèces présentes :");
            for (Species species : environment.speciesList) {
                System.out.println("- " + species.getName() + " (Énergie : " + species.getEnergy() + ")");
            }
            System.out.println();
        }
    }

    // Ajouter un environnement à l'écosystème
    public void ajouterEnvironnement(Environment environment) {
        listOfEnvironments.add(environment);
        System.out.println("Environnement ajouté : " + environment.getClass().getSimpleName());
    }

    // Ajouter une espèce à l'écosystème
    public void ajouterEspece(Species species) {
        listOfSpecies.add(species);
        species.getEnvironment().ajouterEspece(species);
        System.out.println("Espèce ajoutée : " + species.getName());
    }
}