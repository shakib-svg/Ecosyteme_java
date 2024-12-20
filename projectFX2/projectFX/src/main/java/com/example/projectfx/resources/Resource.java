package com.example.projectfx.resources;

import com.example.projectfx.interfaces.Consumable;

public abstract class Resource implements Consumable {
    protected String type;
    protected int quantity;

    public Resource(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Regenerate grass based on its growth rate
    public abstract void regenerate();
}
