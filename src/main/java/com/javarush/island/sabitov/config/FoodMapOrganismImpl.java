package com.javarush.island.sabitov.config;
import com.javarush.island.sabitov.actions.FoodMapOrganism;

import java.util.Map;

public class FoodMapOrganismImpl implements FoodMapOrganism {
    private final Map<String, Integer> preyMap;

    public FoodMapOrganismImpl(Map<String, Integer> preyMap) {
        this.preyMap = preyMap;
    }

    @Override
    public int getFoodItem(String preyName) {
        return preyMap.getOrDefault(preyName, 0);
    }
}
