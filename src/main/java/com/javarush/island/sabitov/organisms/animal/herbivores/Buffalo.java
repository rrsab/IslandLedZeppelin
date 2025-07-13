package com.javarush.island.sabitov.organisms.animal.herbivores;

import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Buffalo extends Herbivorous {
    private static final AnimalProperties BUFFALO_PROPERTY = new AnimalProperties(700,10,3,100);

    public Buffalo() {
        super("Buffalo", "\uD83E\uDDA3", BUFFALO_PROPERTY);
    }
}
