package com.javarush.island.sabitov.organisms.animal.predators;

import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Eagle extends Predator{
    private static final AnimalProperties EAGLE_PROPERTY = new AnimalProperties(6,20,3,1);

    public Eagle() {
        super("Eagle", "\uD83E\uDD85", EAGLE_PROPERTY);
    }

}
