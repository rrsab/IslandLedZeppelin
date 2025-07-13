package com.javarush.island.sabitov.organisms.animal.herbivores;

import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Sheep extends Herbivorous {
    private static final AnimalProperties SHEEP_PROPERTY = new AnimalProperties(70,140,3,15);

    public Sheep() {
        super("Sheep", "\uD83D\uDC11", SHEEP_PROPERTY);
    }
}
