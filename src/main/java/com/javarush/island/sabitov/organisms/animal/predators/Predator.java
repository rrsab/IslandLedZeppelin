package com.javarush.island.sabitov.organisms.animal.predators;

import com.javarush.island.sabitov.organisms.animal.Animal;
import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public abstract class Predator extends Animal {
    public Predator(String name, String icon, AnimalProperties properties) {
        super(name, icon, properties);
    }

    @Override
    public Predator clone() {
        return (Predator) super.clone();
    }
}
