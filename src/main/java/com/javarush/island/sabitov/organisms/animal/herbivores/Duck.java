package com.javarush.island.sabitov.organisms.animal.herbivores;

import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Duck extends Herbivorous {
    private static final AnimalProperties DUCK_PROPERTY = new AnimalProperties(1,200,4,0.15);

    public Duck() {
        super("Duck", "\uD83E\uDD86", DUCK_PROPERTY);
    }
}
