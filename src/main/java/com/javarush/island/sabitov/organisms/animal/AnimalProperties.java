package com.javarush.island.sabitov.organisms.animal;

import com.javarush.island.sabitov.organisms.OrganismProperties;

public class AnimalProperties extends OrganismProperties {

    private final int maxSpeed;
    private final double foodRequired;

    public AnimalProperties(double weight, int maxPerCell, int maxSpeed, double foodRequired) {
        super(weight, maxPerCell);
        this.maxSpeed = maxSpeed;
        this.foodRequired = foodRequired;


    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getFoodRequired() {
        return foodRequired;
    }
}
