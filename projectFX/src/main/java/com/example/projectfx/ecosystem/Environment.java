package com.example.projectfx.ecosystem;

import com.example.projectfx.resources.Resource;
import com.example.projectfx.species.Species;

import java.util.ArrayList;
import java.util.List;

public abstract class Environment {
    // Attributes
    protected List<Resource> resources = new ArrayList<>();
    protected List<Species> speciesList = new ArrayList<>();
    protected String currentSeason = "Spring"; // Default season

    // Abstract method to apply specific rules for the environment
    public abstract void appliquerReglesEnvironment();

    // Update the season and apply seasonal effects
    public void mettreAJourSaison(String newSeason) {
        this.currentSeason = newSeason;
        System.out.println("Saison actuelle : " + currentSeason);

        // Seasonal effects on resources
        switch (currentSeason) {
            case "Spring":
                regenererRessources(10); // Spring: Increase resources
                break;
            case "Summer":
                regenererRessources(5); // Summer: Moderate regeneration
                break;
            case "Autumn":
                diminuerRessources(5); // Autumn: Moderate decrease
                break;
            case "Winter":
                diminuerRessources(10); // Winter: Significant decrease
                break;
            default:
                System.out.println("Saison inconnue, aucun effet appliqué.");
        }
    }

    // Add a species to the environment
    public void ajouterEspece(Species species) {
        speciesList.add(species);
        System.out.println("Espèce ajoutée : " + species.getName());
    }
    public void retirerEspece(Species species) {
        if (speciesList.remove(species)) {
            System.out.println("Species removed: " + species.getName());
        } else {
            System.out.println("Species not found: " + species.getName());
        }
    }

    // Add a resource to the environment
    public void ajouterResource(Resource resource) {
        resources.add(resource);
        System.out.println("Ressource ajoutée : " + resource.getType());
    }

    // Regenerate resources
    protected void regenererRessources(int amount) {
        for (Resource resource : resources) {
            resource.setQuantity(resource.getQuantity() + amount);
            System.out.println(resource.getType() + " régénéré(e) de " + amount + " unités.");
        }
    }

    // Decrease resources
    protected void diminuerRessources(int amount) {
        for (Resource resource : resources) {
            resource.setQuantity(Math.max(0, resource.getQuantity() - amount)); // Avoid negative quantities
            System.out.println(resource.getType() + " diminué(e) de " + amount + " unités.");
        }
    }
}