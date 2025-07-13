package com.javarush.island.sabitov.organisms.plant;

import com.javarush.island.sabitov.island.Island;
import com.javarush.island.sabitov.organisms.Organism;

import java.util.concurrent.ThreadLocalRandom;

public class Grass extends Organism<PlantProperties> {
    private static final PlantProperties PLANT_PROPERTY = new PlantProperties(1, 200);

    public Grass() {
        super("Grass", "🌿", PLANT_PROPERTY);
    }

    @Override
    public String toString() {
        return this.getName() + this.getIcon();
    }

    @Override
    public Grass clone() {
        return (Grass) super.clone();
    }

    @Override
    public void act(Island island) {
        reproduce(island);
    }


    @Override
    public void reproduce(Island island) {

        currentLocation.getLock().lock();
        try {

            long sameSpecies = currentLocation.getOrganisms().stream()
                    .filter(o -> this.getClass().isInstance(o))
                    .count();

            int maxCount = this.getProperties().getMaxPerCell();
            if (sameSpecies < this.getProperties().getMaxPerCell()) {

                long missing = maxCount - sameSpecies;
                long newCount = ThreadLocalRandom.current().nextLong(1, (missing + 1));

                for (int i = 0; i < newCount; i++) {
                    Organism clonedOrganism;
                    synchronized (this) {
                        clonedOrganism = this.clone();
                    }
                    currentLocation.getOrganisms().add(clonedOrganism);
                }

            }
        } finally {
            currentLocation.getLock().unlock();
        }
    }


}
