package com.example.projectfx.resources;

public class Grass extends Resource {
    private double growthRate; // Rate at which the grass regenerates (e.g., 0.2 for 20% growth per cycle)

    // Constructor
    public Grass(int quantity, double growthRate) {
        super("Grass", quantity);
        this.growthRate = growthRate;
    }

    // Getter and setter for growthRate
    public double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    // Regenerate grass based on its growth rate
    @Override
    public void regenerate() {
        int regeneratedAmount = (int) (quantity * growthRate);
        quantity += regeneratedAmount;
        System.out.println(type + " régénérée de " + regeneratedAmount + " unités. Quantité totale : " + quantity);
    }

    // Consume grass (reduce its quantity)
    public void consume(int amount) {
        if (amount > quantity) {
            System.out.println("Pas assez d'herbe à consommer. Tout est consommé.");
            quantity = 0;
        } else {
            quantity -= amount;
            System.out.println(amount + " unités de " + type + " consommées. Quantité restante : " + quantity);
        }
    }

    @Override
    public boolean isConsumed() {
        return false;
    }
}