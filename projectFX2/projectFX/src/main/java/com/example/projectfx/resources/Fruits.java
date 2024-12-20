package com.example.projectfx.resources;

public class Fruits extends Resource {
    private double ripeningRate; // Rate at which the fruits ripen or grow back (e.g., 0.15 for 15% growth per cycle)

    // Constructor
    public Fruits(int quantity, double ripeningRate) {
        super("Fruits", quantity);
        this.ripeningRate = ripeningRate;
    }

    // Getter and setter for ripeningRate
    public double getRipeningRate() {
        return ripeningRate;
    }

    public void setRipeningRate(double ripeningRate) {
        this.ripeningRate = ripeningRate;
    }

    // Regenerate fruits based on their ripening rate
    @Override
    public void regenerate() {
        int regeneratedAmount = (int) (quantity * ripeningRate);
        quantity += regeneratedAmount;
        System.out.println(type + " régénérés de " + regeneratedAmount + " unités. Quantité totale : " + quantity);
    }

    // Consume fruits (reduce their quantity)
    public void consume(int amount) {
        if (amount > quantity) {
            System.out.println("Pas assez de fruits à consommer. Tout est consommé.");
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
