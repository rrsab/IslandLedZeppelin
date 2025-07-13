package com.javarush.island.sabitov.organisms;

public abstract class OrganismProperties implements Cloneable {
    private final double weight;
    private final int maxPerCell;

    public OrganismProperties(double weight, int maxPerCell) {
        this.weight = weight;
        this.maxPerCell = maxPerCell;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxPerCell() {
        return maxPerCell;
    }

    @Override
    public OrganismProperties clone() {
        try {
            return (OrganismProperties) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e);
        }
    }
}
