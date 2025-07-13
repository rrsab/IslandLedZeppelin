package com.javarush.island.sabitov.organisms.animal.herbivores;

import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Goat  extends Herbivorous{
    private static final AnimalProperties GOAT_PROPERTY = new AnimalProperties(60,140,3,10);

    public Goat() {
        super("Goat", "\uD83D\uDC10", GOAT_PROPERTY);
    }
}
