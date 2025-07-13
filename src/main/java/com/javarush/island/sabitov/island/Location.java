package com.javarush.island.sabitov.island;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import com.javarush.island.sabitov.organisms.Organism;
import com.javarush.island.sabitov.organisms.OrganismProperties;


public class Location {
    private final int x;
    private final int y;
    private final List<Organism<? extends OrganismProperties>> organisms = new ArrayList<>();

    private final ReentrantLock lock = new ReentrantLock();


    public Location(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void addOrganism(Organism<? extends OrganismProperties> organism) {
        lock.lock();
        try {
            long sameTypeCount = organisms.stream()
                    .filter(o -> o.getClass().equals(organism.getClass()))
                    .count();

            int max = organism.getProperties().getMaxPerCell();

            if (sameTypeCount < max) {
                organisms.add(organism);
            }
        } finally {
            lock.unlock();
        }
    }

    public String getIconSummary() {
        if (organisms.isEmpty()) {
            return " .  ";
        }

        Map<String, Long> counts = organisms.stream()
                .collect(Collectors.groupingBy(Organism::getIcon, Collectors.counting()));

        return counts.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .map(e -> e.getKey() + e.getValue())
                .collect(Collectors.joining(""));
    }

    public List<Organism<? extends OrganismProperties>> getOrganisms() {
        return organisms;
    }

    public void removeOrganism(Organism<? extends OrganismProperties> organism) {
        lock.lock();
        try {
            organisms.remove(organism);
        } finally {
            lock.unlock();
        }
    }


}