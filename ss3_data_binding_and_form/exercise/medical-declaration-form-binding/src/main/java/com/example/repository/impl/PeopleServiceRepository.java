package com.example.repository.impl;

import com.example.model.People;
import com.example.repository.IPeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PeopleServiceRepository implements IPeopleRepository {
    static Map<Integer, People> peopleMap;
    @Override
    public People findById(Integer id) {
        return null;
    }

    @Override
    public List<People> findAll() {
        return null;
    }

    @Override
    public void save(People peopleObj) {

    }
}
