package com.example.projectfx.ecosystem;

public class Forest extends Environment {
    private double treeDensity; // Density of trees in the forest

    // Constructor
    public Forest(double treeDensity) {
        this.treeDensity = treeDensity;
    }

    // Apply specific rules for the forest
    @Override
    public void appliquerReglesEnvironment() {
        System.out.println("Appliquer les règles spécifiques à la forêt.");
        // Example: Adjust tree density based on the number of herbivores
        if (!speciesList.isEmpty()) {
            double herbivoresCount = speciesList.stream()
                    .filter(species -> species.getClass().getSimpleName().equals("Herbivore"))
                    .count();
            this.treeDensity -= herbivoresCount * 0.01; // Example adjustment
            System.out.println("Densité des arbres ajustée : " + treeDensity);
        }
    }

    // Update the season and apply specific forest rules
    @Override
    public void mettreAJourSaison(String newSeason) {
        super.mettreAJourSaison(newSeason);

        // Additional effects for specific seasons
        switch (currentSeason) {
            case "Spring":
                System.out.println("La forêt fleurit, attirant davantage d'herbivores.");
                break;
            case "Summer":
                System.out.println("Les arbres produisent beaucoup de fruits en été.");
                break;
            case "Autumn":
                System.out.println("Les feuilles tombent, limitant les ressources.");
                break;
            case "Winter":
                System.out.println("Les arbres perdent toutes leurs feuilles, ressources réduites.");
                break;
            default:
                System.out.println("Effets saisonniers inconnus.");
                break;
        }
    }

    // Getter and setter for treeDensity
    public double getTreeDensity() {
        return treeDensity;
    }

    public void setTreeDensity(double treeDensity) {
        this.treeDensity = treeDensity;
    }
}