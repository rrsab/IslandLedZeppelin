package com.javarush.island.sabitov.organisms.animal.herbivores;

import com.javarush.island.sabitov.island.Island;
import com.javarush.island.sabitov.island.Location;
import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Rabbit extends Herbivorous {
private static final AnimalProperties RABBIT_PROPERTY = new AnimalProperties(2,150,2,0.45);


    public Rabbit() {
        super("Rabbit", " \uD83D\uDC07", RABBIT_PROPERTY);
    }

    @Override
    public Rabbit clone() {
        return (Rabbit) super.clone();
    }

    @Override
    public void reproduce(Island island) {

    }
}
