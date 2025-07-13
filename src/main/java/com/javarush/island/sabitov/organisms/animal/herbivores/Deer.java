package com.javarush.island.sabitov.organisms.animal.herbivores;

import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Deer extends Herbivorous {
    private static final AnimalProperties DEER_PROPERTY = new AnimalProperties(300,20,4,50);

    public Deer() {
        super("Deer", "\uD83E\uDD8C", DEER_PROPERTY);
    }
}
