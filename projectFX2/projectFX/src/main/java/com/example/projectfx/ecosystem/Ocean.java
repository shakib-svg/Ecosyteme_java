package com.example.projectfx.ecosystem;

public class Ocean extends Environment {
    private double salinity; // Salinity level of the ocean (e.g., in parts per thousand)

    // Constructor
    public Ocean(double salinity) {
        this.salinity = salinity;
    }

    // Apply specific rules for the ocean
    @Override
    public void appliquerReglesEnvironment() {
        System.out.println("Appliquer les règles spécifiques à l'océan.");
        // Example: Adjust salinity based on environmental factors
        if (!speciesList.isEmpty()) {
            long marineHerbivoresCount = speciesList.stream()
                    .filter(species -> species.getClass().getSimpleName().equals("MarineHerbivore"))
                    .count();
            this.salinity -= marineHerbivoresCount * 0.1; // Example adjustment for simplicity
            System.out.println("Niveau de salinité ajusté : " + salinity);
        }
    }

    // Update the season and apply specific ocean rules
    @Override
    public void mettreAJourSaison(String newSeason) {
        super.mettreAJourSaison(newSeason);

        // Additional seasonal effects for the ocean
        switch (currentSeason) {
            case "Spring":
                System.out.println("Les algues prolifèrent grâce aux conditions favorables.");
                break;
            case "Summer":
                System.out.println("Les températures élevées augmentent la productivité marine.");
                break;
            case "Autumn":
                System.out.println("Les tempêtes automnales affectent les ressources marines.");
                break;
            case "Winter":
                System.out.println("La température de l'eau baisse, ralentissant la reproduction.");
                break;
            default:
                System.out.println("Effets saisonniers inconnus.");
                break;
        }
    }

    // Getter and setter for salinity
    public double getSalinity() {
        return salinity;
    }

    public void setSalinity(double salinity) {
        this.salinity = salinity;
    }
}