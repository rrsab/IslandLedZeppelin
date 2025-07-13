package com.javarush.island.sabitov.executor;


import com.javarush.island.sabitov.island.Island;
import com.javarush.island.sabitov.island.Location;
import com.javarush.island.sabitov.organisms.Organism;
import com.javarush.island.sabitov.organisms.OrganismProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class EvolutionScheduler {
    private final Island island;
    private final Evolution evolution;
    private final ScheduledExecutorService scheduler;
    private final int maxTicks;
    private int tickCount = 0;

    public EvolutionScheduler(Island island, Evolution evolution, int maxTicks) {
        this.island = island;
        this.evolution = evolution;
        this.maxTicks = maxTicks;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void start(long delayMillis) {
        scheduler.scheduleAtFixedRate(this::runTick, 0, delayMillis, TimeUnit.MILLISECONDS);
    }


    private void runTick() {
        tickCount++;

        List<Organism<? extends OrganismProperties>> organisms = new ArrayList<>();
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWeight(); x++) {
                Location location = island.getLocation(y, x);
                organisms.addAll(location.getOrganisms());
            }

        }

        evolution.startEvolution(island, organisms);


        if (tickCount >= maxTicks) {
            scheduler.shutdown();
            System.out.println("scheduler finished");
        }
    }
}


