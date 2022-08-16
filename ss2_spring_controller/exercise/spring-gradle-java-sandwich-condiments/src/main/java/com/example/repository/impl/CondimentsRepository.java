package com.example.repository.impl;

import com.example.repository.ICondimentsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CondimentsRepository implements ICondimentsRepository {
    private static List<String> condimentsList = new ArrayList<>();

    static {
        condimentsList.add("Lettuce");
        condimentsList.add("Tomato");
        condimentsList.add("Mustard");
        condimentsList.add("Sprouts");
    }

    @Override
    public List<String> findAllCondiments() {
        return condimentsList;
    }

    @Override
    public List<String> saveCondiments(String[] condiments) {
        List<String> selectCondiments = new ArrayList<>();
        for (int i = 0; i < condiments.length; i++ ){
            selectCondiments.add(condiments[i]);
        }
        return selectCondiments;
    }
}
