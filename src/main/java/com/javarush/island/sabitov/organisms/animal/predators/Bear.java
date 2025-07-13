package com.javarush.island.sabitov.organisms.animal.predators;

import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Bear extends Predator {
    private static final AnimalProperties BEAR_PROPERTY = new AnimalProperties(500,5,2,80);

    public Bear() {
        super("Bear", "\uD83D\uDC3B", BEAR_PROPERTY);
    }
}
