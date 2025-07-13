package com.javarush.island.sabitov.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.javarush.island.sabitov.actions.FoodMap;
import com.javarush.island.sabitov.actions.FoodMapOrganism;

import java.io.InputStream;
import java.util.Map;

public class FoodConfigLoader {
    public static final Map<String, Map<String, Integer>> foodMap;

    static {
        try (InputStream input = FoodConfigLoader.class.getClassLoader().getResourceAsStream("burkhanova/foodmap.yaml")) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            foodMap = mapper.readValue(input, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Could not load yaml file", e);
        }
    }

    public static int getChanceToBeEaten(String predator, String prey) {
        return foodMap
                .getOrDefault(predator, Map.of())
                .getOrDefault(prey, 0);
    }

    public static FoodMap getAsFoodMap() {
        return new FoodMapAdapter(foodMap);
    }

    private static class FoodMapAdapter implements FoodMap {
        private final Map<String, Map<String, Integer>> rawMap;

        public FoodMapAdapter(Map<String, Map<String, Integer>> rawMap) {
            this.rawMap = rawMap;
        }

        @Override
        public FoodMapOrganism getFoodMap(String predatorName) {
            Map<String, Integer> preyMap = rawMap.getOrDefault(predatorName, Map.of());
            return new FoodMapOrganismImpl(preyMap);
        }
    }
}

