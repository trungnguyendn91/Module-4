package com.example.service.impl;

import com.example.repository.ICondimentsRepository;
import com.example.service.ICondiments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentsService implements ICondiments {
    @Autowired
    private ICondimentsRepository iTranslateRepository;


    @Override
    public List<String> findAllCondiments() {
        return iTranslateRepository.findAllCondiments();
    }

    @Override
    public List<String> saveCondiments(String[] condiments) {
        return iTranslateRepository.saveCondiments(condiments);
    }
}
