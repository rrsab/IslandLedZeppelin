package com.javarush.island.sabitov.organisms.animal;

import com.javarush.island.sabitov.actions.*;
import com.javarush.island.sabitov.config.FoodConfigLoader;
import com.javarush.island.sabitov.island.Island;
import com.javarush.island.sabitov.island.Location;
import com.javarush.island.sabitov.organisms.Organism;
import com.javarush.island.sabitov.organisms.plant.Grass;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.locks.ReentrantLock;


public abstract class Animal<T extends AnimalProperties> extends Organism<T> implements Eat, Move, Reproduce {
    protected double currentFood = 0;


    public Animal(String name, String icon, T properties) {
        super(name, icon, properties);

    }


    @Override
    public Animal<T> clone() {
        return (Animal<T>) super.clone();
    }


    @Override
    public void eat(Island island) {
        if (currentLocation == null) return;

        Location location = currentLocation;
        location.getLock().lock();

        try {
            List<Organism> organisms = new ArrayList<>(location.getOrganisms());
            String predatorName = this.getClass().getSimpleName();

            FoodMap foodMap = FoodConfigLoader.getAsFoodMap();
            FoodMapOrganism foodMapOrganism = foodMap.getFoodMap(predatorName);
            if (foodMapOrganism == null) return;

            double requiredFood = getProperties().getFoodRequired();

            for (Organism organism : organisms) {
                if (organism == this || organism.getProperties().getWeight() == 0.0) continue;

                String preyName = organism.getClass().getSimpleName();
                int chance = foodMapOrganism.getFoodItem(preyName);
                int roll = new Random().nextInt(100);

                if (roll < chance) {
                    synchronized (organism) {
                        if (!location.getOrganisms().contains(organism)) continue;

                        if (organism instanceof Grass) {
                            double gained = organism.getProperties().getWeight();
                            currentFood = Math.min(requiredFood, currentFood + gained);

                            // Удаляем растение из локации
                            location.removeOrganism(organism);
                            break;
                        } else if (organism instanceof Animal prey) {

                            int chanceToEat = FoodConfigLoader.getChanceToBeEaten(predatorName, prey.getClass().getSimpleName());
                            int random = new Random().nextInt(100);

                            if (random < chanceToEat) {

                                double gained = prey.getProperties().getWeight();
                                currentFood = Math.min(requiredFood, currentFood + gained);
                                location.removeOrganism(prey);
                                break;
                            }
                        }
                    }
                }
            }
        } finally {
            location.getLock().unlock();
        }
    }

    @Override
    public void move(Island island) {

        if (currentLocation == null) {
            throw new IllegalStateException("Animal has no assigned location");
        }


        int speed = properties.getMaxSpeed();
        Random random = new Random();

        int currentX = currentLocation.getX();
        int currentY = currentLocation.getY();


        int dx = random.nextInt(2 * speed + 1) - speed;
        int dy = random.nextInt(2 * speed + 1) - speed;


        int newX = currentX + dx;
        int newY = currentY + dy;

        if (newX < 0 || newX >= island.getWeight() || newY < 0 || newY >= island.getHeight()) {
            return;
        }

        Location source = currentLocation;
        Location destination = island.getLocation(newY, newX);

        source.getLock().lock();
        destination.getLock().lock();

        try {
            if (source.getOrganisms().remove(this)) {
                destination.addOrganism(this);
                setCurrentLocation(destination);
            }
        } finally {
            destination.getLock().unlock();
            source.getLock().unlock();
        }

    }

    @Override
    public void reproduce(Island island) {

        if (currentLocation == null) {
            System.out.println("Reproduce: currentLocation is null");
            return;
        }

        Location location = this.getCurrentLocation();
        location.getLock().lock();

        try {
            List<Organism> sameSpecies = location.getOrganisms().stream()
                    .filter(o -> o.getClass().equals(this.getClass()))
                    .collect(Collectors.toList());

            if (sameSpecies.size() > 1) {
                int chance = new Random().nextInt(100);
                if (chance < 50) {
                    long count = sameSpecies.size();
                    int maxPerCell = this.getProperties().getMaxPerCell();
                    if (count >= maxPerCell) {

                        return;
                    }

                    Animal child = this.clone();
                    child.setCurrentLocation(location);
                    location.addOrganism(child);


                }


            }
        } finally {
            location.getLock().unlock();
        }
    }


    public void act(Island island) {
        move(island);
        eat(island);
        reproduce(island);
    }
}
