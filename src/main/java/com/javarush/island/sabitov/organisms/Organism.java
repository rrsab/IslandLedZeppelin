package com.javarush.island.sabitov.organisms;

import com.javarush.island.sabitov.actions.Reproduce;
import com.javarush.island.sabitov.island.Island;
import com.javarush.island.sabitov.island.Location;

import java.util.concurrent.locks.ReentrantLock;

public abstract class Organism<T extends OrganismProperties & Cloneable> implements Reproduce, Cloneable {
    private final String name;
    private final String icon;
    protected Location currentLocation;
    protected T properties;
    private final ReentrantLock lock = new ReentrantLock();


    public Organism(String name, String icon, T properties) {

        this.name = name;
        this.icon = icon;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public T getProperties() {
        return properties;
    }


    public Location getCurrentLocation() {
        return currentLocation;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public Organism<T> clone() {
        try {
            Organism<T> cloned = (Organism<T>) super.clone();
            cloned.properties = (T) this.properties.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e);
        }
    }

    public abstract void act(Island island);


    public abstract void reproduce(Island island);
}
