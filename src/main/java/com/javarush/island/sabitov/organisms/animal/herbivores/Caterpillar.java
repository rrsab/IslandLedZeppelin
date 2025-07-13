package com.javarush.island.sabitov.organisms.animal.herbivores;

import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Caterpillar extends Herbivorous{
    private static final AnimalProperties CATERPILLAR_PROPERTY = new AnimalProperties(0.01,1000,0,0);

    public Caterpillar() {
        super("Caterpillar", "\uD83D\uDC1B", CATERPILLAR_PROPERTY);
    }
}
