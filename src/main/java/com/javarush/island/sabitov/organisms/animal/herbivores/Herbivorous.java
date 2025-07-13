package com.javarush.island.sabitov.organisms.animal.herbivores;

import com.javarush.island.sabitov.organisms.OrganismProperties;
import com.javarush.island.sabitov.organisms.animal.Animal;
import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public abstract class Herbivorous extends Animal<AnimalProperties> {
    public Herbivorous(String name, String icon, AnimalProperties properties) {
        super(name, icon, properties);
    }

    @Override
    public Herbivorous clone() {
        return (Herbivorous) super.clone();
    }

}
