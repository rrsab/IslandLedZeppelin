package com.javarush.island.sabitov.organisms.animal.herbivores;

import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Mouse extends Herbivorous{
    private static final AnimalProperties MOUSE_PROPERTY = new AnimalProperties(0.05,500,1,0.01);

    public Mouse() {
        super("Mouse", "\uD83D\uDC01", MOUSE_PROPERTY);
    }
}
