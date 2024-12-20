package com.example.projectfx.ecosystem;

public class Positionn {
    private int x; // X-coordinate
    private int y; // Y-coordinate

    // Constructor
    public Positionn(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters and setters for x and y
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Calculate the distance between two positions
    public double calculateDistance(Positionn other) {
        int deltaX = this.x - other.x;
        int deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // Move the position by a given offset
    public void moveBy(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
        System.out.println("Position mise à jour : (" + this.x + ", " + this.y + ")");
    }

    // String representation of the position
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}