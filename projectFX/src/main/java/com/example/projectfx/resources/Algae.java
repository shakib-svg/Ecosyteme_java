package com.example.projectfx.resources;

public class Algae extends Resource {
    private double reproductionRate; // Rate at which algae reproduce (e.g., 0.3 for 30% growth per cycle)

    // Constructor
    public Algae(int quantity, double reproductionRate) {
        super("Algae", quantity);
        this.reproductionRate = reproductionRate;
    }

    // Getter and setter for reproductionRate
    public double getReproductionRate() {
        return reproductionRate;
    }

    public void setReproductionRate(double reproductionRate) {
        this.reproductionRate = reproductionRate;
    }

    // Regenerate algae based on its reproduction rate
    @Override
    public void regenerate() {
        int regeneratedAmount = (int) (quantity * reproductionRate);
        quantity += regeneratedAmount;
        System.out.println(type + " régénérées de " + regeneratedAmount + " unités. Quantité totale : " + quantity);
    }

    // Consume algae (reduce its quantity)
    public void consume(int amount) {
        if (amount > quantity) {
            System.out.println("Pas assez d'algues à consommer. Tout est consommé.");
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