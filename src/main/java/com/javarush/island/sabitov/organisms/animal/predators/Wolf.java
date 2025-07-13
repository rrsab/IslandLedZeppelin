package com.javarush.island.sabitov.organisms.animal.predators;

import com.javarush.island.sabitov.island.Island;
import com.javarush.island.sabitov.island.Location;
import com.javarush.island.sabitov.organisms.animal.AnimalProperties;

public class Wolf extends Predator{
    private static final AnimalProperties WOLF_PROPERTY = new AnimalProperties(50,30,3,8);

    public Wolf() {
        super("Wolf", "\uD83D\uDC3A", WOLF_PROPERTY);
    }

    @Override
    public Wolf clone() {
        return (Wolf) super.clone();
    }

    @Override
    public void reproduce(Island island) {

    }
}
