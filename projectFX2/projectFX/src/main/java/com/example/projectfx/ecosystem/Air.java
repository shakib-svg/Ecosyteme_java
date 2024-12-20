package com.example.projectfx.ecosystem;

public class Air extends Environment {
    private double windSpeed; // Wind speed in the air environment (e.g., in km/h)

    // Constructor
    public Air(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    // Apply specific rules for the air environment
    @Override
    public void appliquerReglesEnvironment() {
        System.out.println("Appliquer les règles spécifiques à l'air.");
        // Example: Adjust wind speed based on the number of flying species
        if (!speciesList.isEmpty()) {
            long flyingSpeciesCount = speciesList.stream()
                    .filter(species -> species.getClass().getSimpleName().equals("FlyingSpecies")) // Example filter
                    .count();
            this.windSpeed += flyingSpeciesCount * 0.5; // Adjust wind speed for simplicity
            System.out.println("Vitesse du vent ajustée : " + windSpeed + " km/h.");
        }
    }

    // Update the season and apply specific air rules
    @Override
    public void mettreAJourSaison(String newSeason) {
        super.mettreAJourSaison(newSeason);

        // Additional seasonal effects for the air
        switch (currentSeason) {
            case "Spring":
                System.out.println("Les oiseaux migrateurs reviennent dans l'environnement.");
                break;
            case "Summer":
                System.out.println("Les courants thermiques augmentent, facilitant le vol.");
                break;
            case "Autumn":
                System.out.println("Les vents forts perturbent les espèces volantes.");
                break;
            case "Winter":
                System.out.println("Les tempêtes hivernales affectent les déplacements aériens.");
                break;
            default:
                System.out.println("Effets saisonniers inconnus.");
                break;
        }
    }

    // Getter and setter for windSpeed
    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}