package com.javarush.island.sabitov.island;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.javarush.island.sabitov.organisms.Organism;
import com.javarush.island.sabitov.organisms.animal.herbivores.*;
import com.javarush.island.sabitov.organisms.animal.predators.*;
import com.javarush.island.sabitov.organisms.plant.Grass;


public class Island {
    private final int weight = 20;
    private final int height = 50;
    private final Location[][] map = new Location[height][weight];

    public Location getLocation(int x, int y) {
        return map[x][y];

    }

    public int getWeight() {
        return map[0].length;

    }

    public int getHeight() {
        return map.length;
    }

    public Island() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < weight; x++) {
                map[y][x] = new Location(x, y);

            }

        }
    }

    public void populateRandomly() {
        Random random = new Random();

        Rabbit rabbitPrototype = new Rabbit();
        Grass plantPrototype = new Grass();
        Wolf wolfPrototype = new Wolf();
        Fox foxProtoType = new Fox();
        Eagle eagleProtoType = new Eagle();
        Boa boaProtoType = new Boa();
        Bear bearProtoType = new Bear();
        Boar boarProtoType = new Boar();
        Buffalo buffaloProtoType = new Buffalo();
        Caterpillar caterpillarProtoType = new Caterpillar();
        Deer deerProtoType = new Deer();
        Duck duckProtoType = new Duck();
        Goat goatProtoType = new Goat();
        Horse horseProtoType = new Horse();
        Mouse mouseProtoType = new Mouse();
        Sheep sheepProtoType = new Sheep();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < weight; x++) {
                Location loc = map[y][x];

                int rabbitMax = rabbitPrototype.getProperties().getMaxPerCell();
                int wolfMax = wolfPrototype.getProperties().getMaxPerCell();
                int plantMax = plantPrototype.getProperties().getMaxPerCell();
                int foxMax = foxProtoType.getProperties().getMaxPerCell();
                int eagleMax = eagleProtoType.getProperties().getMaxPerCell();
                int boaMax = boaProtoType.getProperties().getMaxPerCell();
                int bearMax = bearProtoType.getProperties().getMaxPerCell();
                int boarMax = boarProtoType.getProperties().getMaxPerCell();
                int buffaloMax = buffaloProtoType.getProperties().getMaxPerCell();
                int caterpillarMax = caterpillarProtoType.getProperties().getMaxPerCell();
                int deerMax = deerProtoType.getProperties().getMaxPerCell();
                int duckMax = duckProtoType.getProperties().getMaxPerCell();
                int goatMax = goatProtoType.getProperties().getMaxPerCell();
                int horseMax = horseProtoType.getProperties().getMaxPerCell();
                int mouseMax = mouseProtoType.getProperties().getMaxPerCell();
                int sheepMax = sheepProtoType.getProperties().getMaxPerCell();


                int rabbitCount = random.nextInt(rabbitMax + 1);
                int wolfCount = random.nextInt(wolfMax + 1);
                int plantCount = random.nextInt(plantMax + 1);
                int foxCount = random.nextInt(foxMax + 1);
                int eagleCount = random.nextInt(eagleMax + 1);
                int boaCount = random.nextInt(boaMax + 1);
                int bearCount = random.nextInt(bearMax + 1);
                int boarCount = random.nextInt(boarMax + 1);
                int buffaloCount = random.nextInt(buffaloMax + 1);
                int caterpillarCount = random.nextInt(caterpillarMax + 1);
                int deerCount = random.nextInt(deerMax + 1);
                int duckCount = random.nextInt(duckMax + 1);
                int goatCount = random.nextInt(goatMax + 1);
                int horseCount = random.nextInt(horseMax + 1);
                int mouseCount = random.nextInt(mouseMax + 1);
                int sheepCount = random.nextInt(sheepMax + 1);

                for (int i = 0; i < sheepCount; i++) {
                    Sheep sheep = (Sheep) sheepProtoType.clone();
                    sheep.setCurrentLocation(loc);
                    loc.addOrganism(sheep);
                }

                for (int i = 0; i < mouseCount; i++) {
                    Mouse mouse = (Mouse) mouseProtoType.clone();
                    mouse.setCurrentLocation(loc);
                    loc.addOrganism(mouse);
                }

                for (int i = 0; i < horseCount; i++) {
                    Horse horse = (Horse) horseProtoType.clone();
                    horse.setCurrentLocation(loc);
                    loc.addOrganism(horse);
                }

                for (int i = 0; i < goatCount; i++) {
                    Goat goat = (Goat) goatProtoType.clone();
                    goat.setCurrentLocation(loc);
                    loc.addOrganism(goat);
                }

                for (int i = 0; i < deerCount; i++) {
                    Deer deer = (Deer) deerProtoType.clone();
                    deer.setCurrentLocation(loc);
                    loc.addOrganism(deer);
                }

                for (int i = 0; i < duckCount; i++) {
                    Duck duck = (Duck) duckProtoType.clone();
                    duck.setCurrentLocation(loc);
                    loc.addOrganism(duck);
                }

                for (int i = 0; i < caterpillarCount; i++) {
                    Caterpillar caterpillar = (Caterpillar) caterpillarProtoType.clone();
                    caterpillar.setCurrentLocation(loc);
                    loc.addOrganism(caterpillar);
                }

                for (int i = 0; i < buffaloCount; i++) {
                    Buffalo buffalo = (Buffalo) buffaloProtoType.clone();
                    buffalo.setCurrentLocation(loc);
                    loc.addOrganism(buffalo);
                }

                for (int i = 0; i < bearCount; i++) {
                    Bear bear = (Bear) bearProtoType.clone();
                    bear.setCurrentLocation(loc);
                    loc.addOrganism(bear);
                }

                for (int i = 0; i < boarCount; i++) {
                    Boar boar = (Boar) boarProtoType.clone();
                    boar.setCurrentLocation(loc);
                    loc.addOrganism(boar);
                }
                for (int i = 0; i < boaCount; i++) {
                    Boa boa = (Boa) boaProtoType.clone();
                    boa.setCurrentLocation(loc);
                    loc.addOrganism(boa);
                }

                for (int i = 0; i < eagleCount; i++) {
                    Eagle eagle = (Eagle) eagleProtoType.clone();
                    eagle.setCurrentLocation(loc);
                    loc.addOrganism(eagle);
                }
                for (int i = 0; i < rabbitCount; i++) {
                    Rabbit rabbit = rabbitPrototype.clone();
                    rabbit.setCurrentLocation(loc);
                    loc.addOrganism(rabbit);
                }
                for (int i = 0; i < plantCount; i++) {
                    Grass plant = plantPrototype.clone();
                    plant.setCurrentLocation(loc);
                    loc.addOrganism(plant);
                }

                for (int i = 0; i < wolfCount; i++) {
                    Wolf wolf = wolfPrototype.clone();
                    wolf.setCurrentLocation(loc);
                    loc.addOrganism(wolf);
                }

                for (int i = 0; i < foxCount; i++) {
                    Fox fox = (Fox) foxProtoType.clone();
                    fox.setCurrentLocation(loc);
                    loc.addOrganism(fox);
                }
            }
        }
    }

    public void printMap() {

        Map<String, Integer> totalStats = new HashMap<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < weight; x++) {
                Location loc = map[y][x];
                List<? extends Organism> organisms = loc.getOrganisms();

                for (Organism organism : organisms) {
                    String type = organism.getClass().getSimpleName();
                    totalStats.put(type, totalStats.getOrDefault(type, 0) + 1);
                }
                System.out.print(loc.getIconSummary() + "  ");

            }
            System.out.println();

        }
        System.out.println("\n=== Total Statistics ===");
        int counter = 0;
        for (Map.Entry<String, Integer> entry : totalStats.entrySet()) {
            System.out.printf("%s: %d  ", entry.getKey(), entry.getValue());
            counter++;
            if (counter % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public Location getRandomLocation() {
        Random random = new Random();
        int x = random.nextInt(weight);
        int y = random.nextInt(height);
        return map[y][x];
    }


}